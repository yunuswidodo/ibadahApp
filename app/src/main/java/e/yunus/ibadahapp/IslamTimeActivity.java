package e.yunus.ibadahapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import e.yunus.ibadahapp.api.ApiService;
import e.yunus.ibadahapp.api.ApiUrl;
import e.yunus.ibadahapp.model.ModelJadwalSholat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IslamTimeActivity extends AppCompatActivity {

    private TextView tv_lokasi_value, tv_fajr_value, tv_shurooq_value, tv_dhuhr_value, tv_asr_value, tv_maghrib_value, tv_isha_value;
    private FloatingActionButton fab_refresh;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islam_time);

        tv_lokasi_value = findViewById(R.id.tv_lokasi_value);
        tv_fajr_value = findViewById(R.id.tv_fajr_value);
        tv_shurooq_value = findViewById(R.id.tv_shurooq_value);
        tv_dhuhr_value = findViewById(R.id.tv_dhuhr_value);
        tv_asr_value = findViewById(R.id.tv_asr_value);
        tv_maghrib_value = findViewById(R.id.tv_maghrib_value);
        tv_isha_value = findViewById(R.id.tv_isha_value);
        fab_refresh = findViewById(R.id.fab_refresh);


        getJadwalSholat();
        fab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJadwalSholat();
            }
        });

//        botton navigation
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.islam_map:
                        Intent intent0= new Intent(IslamTimeActivity.this, IslamMapActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.islam_time:
                        break;
                    case R.id.islam_day:
                        Intent intent2 = new Intent(IslamTimeActivity.this, IslamDayActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.islam_nav:
                        Intent intent3 = new Intent(IslamTimeActivity.this, IslamNavActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }


    private void getJadwalSholat (){

        //
        progressDialog = new ProgressDialog(IslamTimeActivity.this);
        progressDialog.setMessage("silahkan tunggu");
        progressDialog.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiUrl.URL_ROOT_HTTP)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<ModelJadwalSholat> call = apiService.getJadwalSholat();

        call.enqueue(new Callback<ModelJadwalSholat>() {
            @Override
            public void onResponse(Call<ModelJadwalSholat> call, Response<ModelJadwalSholat> response) {
                progressDialog.dismiss();

                if (response.isSuccessful()){
                    tv_lokasi_value.setText(response.body().getQuery()+","+response.body().getItems().get(0).getDateFor());
                    tv_fajr_value.setText(response.body().getItems().get(0).getFajr());
                    tv_shurooq_value.setText(response.body().getItems().get(0).getShurooq());
                    tv_dhuhr_value.setText(response.body().getItems().get(0).getDhuhr());
                    tv_asr_value.setText(response.body().getItems().get(0).getAsr());
                    tv_maghrib_value.setText(response.body().getItems().get(0).getMaghrib());
                    tv_isha_value.setText(response.body().getItems().get(0).getIsha());

            }else {
                }
            }

            @Override
            public void onFailure(Call<ModelJadwalSholat> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(IslamTimeActivity.this, "Sorry, please try again... server Down..", Toast.LENGTH_SHORT).show();
            }
        });
    }


    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(IslamTimeActivity.this, IslamMapActivity.class);
        startActivity(intent);
    }
}
