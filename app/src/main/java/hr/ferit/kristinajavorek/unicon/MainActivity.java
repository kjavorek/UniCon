package hr.ferit.kristinajavorek.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String KEY_DISTANCE = "DISTANCE";
    public static final String KEY_WEIGHT = "WEIGHT";
    public static final String KEY_TIME = "TIME";
    public static final String KEY_SHOES = "SHOES";

    ImageButton bDistanceActivity, bWeightActivity, bTimeActivity, bShoesActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        this.setUpUI();
    }
    private void setUpUI() {
        this.bDistanceActivity = (ImageButton) findViewById(R.id.bDistanceActivity);
        this.bWeightActivity = (ImageButton) findViewById(R.id.bWeightActivity);
        this.bTimeActivity = (ImageButton) findViewById(R.id.bTimeActivity);
        this.bShoesActivity = (ImageButton) findViewById(R.id.bShoesActivity);

        this.bDistanceActivity.setOnClickListener(this);
        this.bWeightActivity.setOnClickListener(this);
        this.bTimeActivity.setOnClickListener(this);
        this.bShoesActivity.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent explicitIntent = new Intent();
        switch(v.getId()){
            case (R.id.bDistanceActivity):
                explicitIntent.setClass(getApplicationContext(), ConvertDistanceAndWeight.class);
                explicitIntent.putExtra(KEY_DISTANCE, KEY_DISTANCE);
                break;
            case (R.id.bWeightActivity):
                explicitIntent.setClass(getApplicationContext(), ConvertDistanceAndWeight.class);
                explicitIntent.putExtra(KEY_WEIGHT, KEY_WEIGHT);
                break;
            case (R.id.bTimeActivity):
                explicitIntent.setClass(getApplicationContext(), ConvertTimeAndShoes.class);
                explicitIntent.putExtra(KEY_TIME, KEY_TIME);
                break;
            case (R.id.bShoesActivity):
                explicitIntent.setClass(getApplicationContext(), ConvertTimeAndShoes.class);
                explicitIntent.putExtra(KEY_SHOES, KEY_SHOES);
                break;
        }
        this.startActivity(explicitIntent);
    }
}
