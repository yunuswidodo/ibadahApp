package e.yunus.ibadahapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProtestanMapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protestan_map);

        TextView title= (TextView) findViewById(R.id.activityTitle1);
        title.setText("this is map activity");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.protestan_map:
                        break;
                    case R.id.protestan_day:
                        Intent intent1 = new Intent(ProtestanMapActivity.this, ProtestanDayActivity.class);
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
        Intent intent = new Intent(ProtestanMapActivity.this, DasboardFirst.class);
        startActivity(intent);
    }
}
