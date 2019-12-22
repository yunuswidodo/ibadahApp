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

public class KonghucuDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konghucu_day);


        ListView mlistView = (ListView)findViewById(R.id.listView);

        //https://doripos.com/inilah-10-hari-besar-umat-kong-hu-chu
        //Create the objects
        Item item1 = new Item(R.drawable.date_konghucu,"Tahun Baru Imlek","1 januari");
        Item item2 = new Item(R.drawable.date_konghucu,"Malaikat Dapur keLangit","tanggal 24 bulan ke12 kalender imlek");
        Item item3 = new Item(R.drawable.date_konghucu,"Sembahyang Arwah Leluhur","tanggal 29 bulan ke12 kalender Imlek.");
        Item item4 = new Item(R.drawable.date_konghucu,"Sembayang kepada Tuhan YME"," tanggal 8 bulan ke1 kelender Imlek.");
        Item item5 = new Item(R.drawable.date_konghucu,"Cap Go Meh","tanggal 15 bulan ke1 kalender imlek");
        Item item6 = new Item(R.drawable.date_konghucu,"Cing Bing","bulan 3 setelah imlek");
        Item item7 = new Item(R.drawable.date_konghucu,"Twan Yang","tanggal 5 bulan ke5 kelender imlek");
        Item item8 = new Item(R.drawable.date_konghucu,"Sembayang Rebutan","tanggal 15 bulan ke7 kalender imlek");
        Item item9 = new Item(R.drawable.date_konghucu,"Sembahyang Tiong Jiu","tanggal 15 bulan ke8 kalender imlek");
        Item item10 = new Item(R.drawable.date_konghucu,"Tang Cik","tanggal 22 Desember Masehi");



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
