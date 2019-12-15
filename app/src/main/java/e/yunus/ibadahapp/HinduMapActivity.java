package e.yunus.ibadahapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

public class HinduMapActivity extends AppCompatActivity implements LocationListener {

    private GoogleMap mGoogleMap;
    private Button btnCari;
    private ProgressBar pBar;
    private double mLatitude = 0;
    private double mLongitude = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu_map);

        btnCari = findViewById(R.id.btnCari);
        pBar = findViewById(R.id.pBar);

        SupportMapFragment fragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        fragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mGoogleMap = googleMap;
                initMap();
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String sb = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?" + "location=" + mLatitude + "," + mLongitude +
                        "&radius=5000" +
                        "&name=Pura Hindu" +
                        "&sensor=true" +
                        "&key=" + getResources().getString(R.string.api_key_web);

                onCari();
                new HinduMapActivity.PlacesTask().execute(sb);
            }
        });


        //bottom navigation
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.hindu_map:
                        break;
                    case R.id.hindu_day:
                        Intent intent1 = new Intent(HinduMapActivity.this, HinduDayActivity.class);
                        startActivity(intent1);

                }
                return false;
            }
        });
    }



    private void initMap() {
        onCari();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 115);
            return;
        }

        if (mGoogleMap != null) {
            mGoogleMap.setMyLocationEnabled(true);

            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = locationManager.getBestProvider(criteria, true);
            Location location = locationManager.getLastKnownLocation(provider);

            if (location != null) {
                onLocationChanged(location);
            }
            locationManager.requestLocationUpdates(provider, 20000, 0, (LocationListener) this);
        }
    }
    @Override
    public void onLocationChanged(Location location) {
        mLatitude = location.getLatitude();
        mLongitude = location.getLongitude();
        LatLng latLng = new LatLng(mLatitude, mLongitude);

        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        onAfterCari();
    }
    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }
    @Override
    public void onProviderDisabled(String s) {

    }
    private class PlacesTask extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... url) {
            String data = null;
            try {
                data = downloadUrl(url[0]);
            } catch (Exception e) {
                onAfterCari();
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            new ParserTask().execute(result);
        }

    }
    private String downloadUrl(String strUrl) {
        String data = "";
        InputStream iStream;
        HttpURLConnection urlConnection;
        try {
            URL url = new URL(strUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuilder sb = new StringBuilder();

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            br.close();
            iStream.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    private class ParserTask extends AsyncTask<String, Integer, List<HashMap<String, String>>> {

        JSONObject jObject;

        @Override
        protected List<HashMap<String, String>> doInBackground(String... jsonData) {

            List<HashMap<String, String>> places = null;
            ParserPlace parserPlace = new ParserPlace();

            try {
                jObject = new JSONObject(jsonData[0]);
                places = parserPlace.parse(jObject);
            } catch (Exception e) {
                onAfterCari();
                e.printStackTrace();
            }
            return places;
        }

        @Override
        protected void onPostExecute(List<HashMap<String, String>> list) {
            // clear map sebelumnya
            mGoogleMap.clear();

            for (int i = 0; i < list.size(); i++) {
                MarkerOptions markerOptions = new MarkerOptions();
                HashMap<String, String> hmPlace = list.get(i);

                double lat = Double.parseDouble(hmPlace.get("lat"));
                double lng = Double.parseDouble(hmPlace.get("lng"));

                String nama = hmPlace.get("place_name");

                LatLng latLng = new LatLng(lat, lng);

                markerOptions.position(latLng);
                markerOptions.title(nama );

                markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_hindu));
                mGoogleMap.addMarker(markerOptions);
            }

            onAfterCari();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 115) {
            for (int i = 0; i < permissions.length; i++) {
                String permission = permissions[i];
                int grantResult = grantResults[i];

                if (permission.equals(Manifest.permission.ACCESS_FINE_LOCATION)) {
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        initMap();
                    } else {
                        ActivityCompat.requestPermissions(HinduMapActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 115);
                    }
                }
            }
        }
    }

    private void onCari() {
        pBar.setVisibility(View.VISIBLE);
        btnCari.setVisibility(View.GONE);
    }

    private void onAfterCari() {
        pBar.setVisibility(View.GONE);
        btnCari.setVisibility(View.VISIBLE);
    }

    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HinduMapActivity.this, DasboardFirst.class);
        startActivity(intent);
    }
}