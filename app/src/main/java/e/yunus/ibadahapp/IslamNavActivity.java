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

public class IslamNavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islam_nav);

        TextView title= (TextView) findViewById(R.id.activityTitle4);
        title.setText("this is four");

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        //icon pindah
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.islam_map:
                        Intent intent0= new Intent(IslamNavActivity.this, IslamMapActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.islam_time:
                        Intent intent1 = new Intent(IslamNavActivity.this, IslamTimeActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.islam_day:
                        Intent intent3 = new Intent(IslamNavActivity.this, IslamDayActivity.class);
                        startActivity(intent3);
                        break;
                    case R.id.islam_nav:
                        break;
                }
                return false;
            }
        });
    }
    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(IslamNavActivity.this, IslamMapActivity.class);
        startActivity(intent);
    }
}
