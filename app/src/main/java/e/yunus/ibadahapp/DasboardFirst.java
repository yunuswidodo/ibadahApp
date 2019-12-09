package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DasboardFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darboard__one);

    }


    public void Islam(View view) {
        Intent intentISlam = new Intent(DasboardFirst.this, IslamMapActivity.class);
        startActivity(intentISlam);
    }

    public void hindu(View view) {
        Intent intentHindu = new Intent(DasboardFirst.this, HinduMapActivity.class);
        startActivity(intentHindu);
    }

    public void budha(View view) {
        Intent intentBudha = new Intent(DasboardFirst.this, BudhaMapActivity.class);
        startActivity(intentBudha);
    }

    public void Protestan(View view) {
        Intent intentProtestan = new Intent(DasboardFirst.this, ProtestanMapActivity.class);
        startActivity(intentProtestan);
    }

    public void katolik(View view) {
        Intent intentKatolik = new Intent(DasboardFirst.this,KatolikMapActivity.class);
        startActivity(intentKatolik);
    }

    public void konghucu(View view) {
        Intent intentKonghucu = new Intent(DasboardFirst.this, KonghucuMapActivity.class);
        startActivity(intentKonghucu);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DasboardFirst.this, MainActivity.class);
        startActivity(intent);
    }
}
