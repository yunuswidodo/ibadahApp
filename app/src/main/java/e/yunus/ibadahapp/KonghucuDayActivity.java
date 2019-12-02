package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class KonghucuDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konghucu_day);

        TextView title= (TextView) findViewById(R.id.activityTitle1);
        title.setText("this is Day Konghuchu");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.konghucu_map:
                        Intent intentDayKonghuu = new Intent(KonghucuDayActivity.this, KonghucuMapActivity.class);
                        startActivity(intentDayKonghuu);
                        break;
                    case R.id.konghucu_day:

                        break;


                }
                return false;
            }
        });

    }
    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(KonghucuDayActivity.this, KonghucuMapActivity.class);
        startActivity(intent);
    }
}
