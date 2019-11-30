package e.yunus.ibadahapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IslamDayActivity extends AppCompatActivity {

    private static final String Tag   ="IslamdDayActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islam_day);

        Log.d(Tag, "onCreate: Started.");
        ListView mlistView = (ListView)findViewById(R.id.listView);

        //Create the Person objects
        Item item1 = new Item(R.drawable.img_islam,"islam","indah");
        Item item2 = new Item(R.drawable.img_islam,"islam","indah");
        Item item3 = new Item(R.drawable.img_islam,"islam","indah");

        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        ItemListAdapter adapter = new ItemListAdapter(this, R.layout.adapter_view_layout, itemList);
        mlistView.setAdapter(adapter);

// ini bottom
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
