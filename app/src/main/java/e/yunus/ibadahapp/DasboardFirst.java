package e.yunus.ibadahapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DasboardFirst extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darboard__one);
    }

    public void Islam(View view) {
        Intent intent = new Intent(DasboardFirst.this, IslamMapActivity.class);
        startActivity(intent);
    }
}