package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class HinduMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu_map);

        TextView title= (TextView) findViewById(R.id.activityTitle1);
        title.setText("this is one hindu");

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

    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HinduMapActivity.this, DasboardFirst.class);
        startActivity(intent);
    }
}