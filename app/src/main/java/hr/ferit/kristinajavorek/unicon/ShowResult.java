package hr.ferit.kristinajavorek.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static hr.ferit.kristinajavorek.unicon.R.id.tvConvert;

public class ShowResult extends AppCompatActivity {

    TextView tvFrom, tvTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        this.setUpUI();
    }

    private void setUpUI() {
        this.tvFrom= (TextView) findViewById(R.id.tvFrom);
        this.tvTo= (TextView) findViewById(R.id.tvTo);

        Intent convertedIntent = this.getIntent();
        tvFrom.setText(convertedIntent.getStringExtra(ConvertDistanceAndWeight.KEY_FROM_NUM) +" "+convertedIntent.getStringExtra(ConvertDistanceAndWeight.KEY_FROM));
        tvTo.setText(convertedIntent.getStringExtra(ConvertDistanceAndWeight.KEY_TO_NUM) +" "+convertedIntent.getStringExtra(ConvertDistanceAndWeight.KEY_TO));
    }
}
