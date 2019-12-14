package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class DasboardFirst extends AppCompatActivity {

    ViewFlipper v_flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darboard__one);

        int images[] = {R.drawable.img_budha, R.drawable.img_hindu, R.drawable.img_islam};
        v_flipper = findViewById(R.id.v_flipper);

        for (int i =0; i<images.length; i++){
            fliverImages(images[i]);
        }
        for (int image: images)
            fliverImages(image);
    }
    public  void  fliverImages(int images){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(images);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

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
