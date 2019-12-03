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

public class BudhaDayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budha_day);

        ListView mlistView = (ListView)findViewById(R.id.listView);

        //https://samaggi-phala.or.id/sangha-theravada-indonesia/hari-raya-agama-buddha-2014-s-d-2026-2/
        //Create the objects
        Item item1 = new Item(R.drawable.img_budha,"Hari Raya Waisak","7 mei");
        Item item2 = new Item(R.drawable.img_budha,"Hari Raya Maghapuja","10 febuari");
        Item item3 = new Item(R.drawable.img_budha,"Hari Raya Asadha","4 juli");
        Item item4 = new Item(R.drawable.img_budha,"Hari Raya Khatina","17 oktober");


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
                    case R.id.budha_map:
                        Intent intent1 = new Intent(BudhaDayActivity.this, HinduMapActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.budha_day:
                        break;



                }
                return false;
            }
        });
    }
    //tombol back
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(BudhaDayActivity.this, BudhaMapActivity.class);
        startActivity(intent);
    }
}
