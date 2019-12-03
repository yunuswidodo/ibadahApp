package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HinduDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindu_day);


        ListView mlistView = (ListView)findViewById(R.id.listView);

        //https://www.balitoursclub.com/berita_499_Hari_Raya_Agama_Hindu_di_Bali.html

        //Create the objects
        Item item1 = new Item(R.drawable.img_hindu,"Hari Raya Galungan","6 bulan sekali kalender Isaka");
        Item item2 = new Item(R.drawable.img_hindu,"Hari Raya Kuningan","10 hari setelah hari galungan");
        Item item3 = new Item(R.drawable.img_hindu,"Hari Raya Sawarati","6 bulan sekali");
        Item item4 = new Item(R.drawable.img_hindu,"Hari Raya Siwarati","setahun sekali kalender saka");
        Item item5 = new Item(R.drawable.img_hindu,"Hari Raya Pager Wesi","6 bulan sekali");
        Item item6 = new Item(R.drawable.img_hindu,"Hari Raya Nyepi","1 tahun sekali kalender Isaka");
        Item item7 = new Item(R.drawable.img_hindu,"Hari Raya Tilem","setiap tanggal 29 & 30");


        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);

        ItemListAdapter adapter = new ItemListAdapter(this, R.layout.adapter_view_layout, itemList);
        mlistView.setAdapter(adapter);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.hindu_map:
                        Intent intent1 = new Intent(HinduDayActivity.this, HinduMapActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.hindu_day:


                }
                return false;
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HinduDayActivity.this, HinduMapActivity.class);
        startActivity(intent);
    }
}
