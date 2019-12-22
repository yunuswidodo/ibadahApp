package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class KatolikDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_katolik_day);


        ListView mlistView = (ListView)findViewById(R.id.listView);

        //https://id.wikipedia.org/wiki/Hari_raya_wajib_(Katolik)
        //Create the objects
        Item item1 = new Item(R.drawable.date_katolik,"Hari Raya Santa Maria","1 januari");
        Item item2 = new Item(R.drawable.date_katolik,"Epifani","6 januari");
        Item item3 = new Item(R.drawable.date_katolik,"Hari Raya Santo Yusuf","19 maret");
        Item item4 = new Item(R.drawable.date_katolik,"Hari Raya Kenaikan Tuhan","kamis dalam minggu paskah VI");
        Item item5 = new Item(R.drawable.date_katolik,"Hari Raya Tubuh & Darah Kristus","Kamis setelah Tritunggal");
        Item item6 = new Item(R.drawable.date_katolik,"Hari Raya Santo Petro & Paulus","19 juni");
        Item item7 = new Item(R.drawable.date_katolik,"Hari Raya santa Maria keSurga","15 agustus");
        Item item8 = new Item(R.drawable.date_katolik,"Hari Raya Orang Kudus","1 november");
        Item item9 = new Item(R.drawable.date_katolik,"Hari Raya Maria Dikandung","8 Desember");
        Item item10 = new Item(R.drawable.date_katolik,"Hari Raya Natal","25 desember");



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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.buttomNavView_Bar);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.katolik_map:
                        Intent intent1 = new Intent(KatolikDayActivity.this, KatolikMapActivity.class);
                        startActivity(intent1);

                        break;
                    case R.id.katolik_day:

                        break;
                }
                return false;
            }
        });
    }
    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(KatolikDayActivity.this, KatolikMapActivity.class);
        startActivity(intent);
    }
}
