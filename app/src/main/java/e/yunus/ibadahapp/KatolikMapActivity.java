package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class KatolikMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katolik_map);

        TextView title= (TextView) findViewById(R.id.activityTitle1);
        title.setText("this is map katolik");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.katolik_map:

                        break;
                    case R.id.katolik_day:
                        Intent intent1 = new Intent(KatolikMapActivity.this, KatolikDayActivity.class);
                        startActivity(intent1);
                        break;



                }
                return false;
            }
        });
    }
    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(KatolikMapActivity.this, DasboardFirst.class);
        startActivity(intent);
    }

    }

