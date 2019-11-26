package e.yunus.ibadahapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class IslamDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islam_day);

        TextView title= (TextView) findViewById(R.id.activityTitle3);
        title.setText("this is tree");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.islam_map:
                        Intent intent0= new Intent(IslamDayActivity.this, IslamMapActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.islam_time:
                        Intent intent1 = new Intent(IslamDayActivity.this, IslamTimeActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.islam_day:
                        break;
                    case R.id.islam_nav:
                        Intent intent3 = new Intent(IslamDayActivity.this, IslamNavActivity.class);
                        startActivity(intent3);
                        break;
                }
                return false;
            }
        });
    }
    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(IslamDayActivity.this, IslamMapActivity.class);
        startActivity(intent);
    }
}
