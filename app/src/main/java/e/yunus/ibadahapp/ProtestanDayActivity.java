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

public class ProtestanDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protestan_day);


        ListView mlistView = (ListView)findViewById(R.id.listView);

        //ketik digoogle hari besar agama protestan
        //Create the objects
        Item item1 = new Item(R.drawable.img_kristenprotestan,"Hari Raya Natal","25 desember");
        Item item2 = new Item(R.drawable.img_kristenprotestan,"Hari Raya Epifani","6 januari");
        Item item3 = new Item(R.drawable.img_kristenprotestan,"Hari Raya Kamis Putih","kamis terakir maret hingga minggu kedua april");
        Item item4 = new Item(R.drawable.img_kristenprotestan,"Hari Raya Kematian Yesus","jumat akhir maret hingga minggu kedua akhir");


        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);

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
                    case R.id.protestan_map:
                        Intent intent1 = new Intent(ProtestanDayActivity.this, ProtestanMapActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.protestan_day:

                        break;
                }
                return false;
            }
        });
    }

    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ProtestanDayActivity.this, ProtestanMapActivity.class);
        startActivity(intent);
    }
}
