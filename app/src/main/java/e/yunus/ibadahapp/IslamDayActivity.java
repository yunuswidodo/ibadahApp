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

        //Create the objects
        Item item1 = new Item(R.drawable.img_islam,"Tahun Baru hijriah","1 Muharram");
        Item item2 = new Item(R.drawable.img_islam,"Asyura","10 Muharam");
        Item item3 = new Item(R.drawable.img_islam,"Maulid Nabi","12 Rabiul Awal");
        Item item4 = new Item(R.drawable.img_islam,"Isra' mi'raj","27 rajab");
        Item item5 = new Item(R.drawable.img_islam,"Bulan Ramadhan","1 Ramadhan");
        Item item6 = new Item(R.drawable.img_islam,"Nuzulul Qur,an","17 Ramadhan");
        Item item7 = new Item(R.drawable.img_islam,"Hari Raya Idhul Fitri","1 Syawal");
        Item item8 = new Item(R.drawable.img_islam,"Wukuf","9 Dzulhijjah");
        Item item9 = new Item(R.drawable.img_islam,"Hari Raya Idul Adha","10 Dzulhijjah");
        Item item10 = new Item(R.drawable.img_islam,"Hari Tasyriq","12 Rabiul Awal");



        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);
        itemList.add(item10);


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
