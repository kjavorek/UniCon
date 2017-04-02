package hr.ferit.kristinajavorek.unicon;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConvertTimeAndShoes extends AppCompatActivity implements View.OnClickListener{

    public static final String KEY_FROM = "Convert from";
    public static final String KEY_TO = "Convert to";
    public static final String KEY_FROM_NUM = "From value";
    public static final String KEY_TO_NUM = "To value";

    TextView tvConvert;
    Button bConvert;
    EditText etConvert;
    Spinner spinner1, spinner2;
    String[] spinner;
    ArrayAdapter<String> adapter;
    String inputData, num, selected1, selected2, result;
    Double numberForConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_convert_distance_and_weight);
        this.setUpUI();
    }
    private void setUpUI() {
        this.tvConvert= (TextView) findViewById(R.id.tvConvert);
        this.etConvert = (EditText) findViewById(R.id.etConvert);
        this.bConvert = (Button) findViewById(R.id.bConvert);
        this.bConvert.setOnClickListener(this);
        this.spinner1 = (Spinner)findViewById(R.id.spinner1);
        this.spinner2 = (Spinner)findViewById(R.id.spinner2);

        Resources res = getResources();
        Intent startingIntent = this.getIntent();
        if(startingIntent.hasExtra(MainActivity.KEY_TIME)){
            inputData = startingIntent.getStringExtra(MainActivity.KEY_TIME);
            tvConvert.setText(inputData+" CONVERTER");
            spinner = res.getStringArray(R.array.spinnerTime);
        }
        if(startingIntent.hasExtra(MainActivity.KEY_SHOES)){
            inputData = startingIntent.getStringExtra(MainActivity.KEY_SHOES);
            tvConvert.setText(inputData +" CONVERTER");
            spinner = res.getStringArray(R.array.spinnerShoes);
        }
        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }
    @Override
    public void onClick(View view) {
        if(etConvert.getText().toString().matches("")){
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        }else {
            selected1 = spinner1.getSelectedItem().toString();
            selected2 = spinner2.getSelectedItem().toString();
            numberForConvert = Double.parseDouble(etConvert.getText().toString());
            num = numberForConvert.toString();
            convert();
            Intent resultIntent = new Intent();
            resultIntent.setClass(getApplicationContext(), ShowResult.class);
            resultIntent.putExtra(KEY_FROM, selected1);
            resultIntent.putExtra(KEY_TO, selected2);
            resultIntent.putExtra(KEY_FROM_NUM, num);
            resultIntent.putExtra(KEY_TO_NUM, result);
            this.startActivity(resultIntent);
        }
    }
    public void convert(){
        if(inputData.equals("TIME")) {
            if (selected1 == selected2) {
                result = numberForConvert.toString();
            } else if (selected1.equals("Weeks") && selected2.equals("Days")) {
                result = (numberForConvert*=7).toString();
            } else if (selected1.equals("Weeks") && selected2.equals("Minutes")) {
                result = (numberForConvert*=10080).toString();
            } else if (selected1.equals("Days") && selected2.equals("Weeks")) {
                result=String.format("%.2f", (numberForConvert*=(1/7)));
            } else if (selected1.equals("Days") && selected2.equals("Minutes")) {
                result = (numberForConvert*=1440).toString();
            } else if (selected1.equals("Minutes") && selected2.equals("Weeks")) {
                result=String.format("%.2f", (numberForConvert*=(1/10080)));
            } else if (selected1.equals("Minutes") && selected2.equals("Days")) {
                result=String.format("%.2f", (numberForConvert*=(1/1440)));
            }
        }
        if(inputData.equals("SHOES")) {
            if (selected1 == selected2) {
                result = numberForConvert.toString();
            } else if (selected1.equals("Europe") && selected2.equals("UK women")) {
                result=String.format("%.2f", (numberForConvert-=32.5));
            } else if (selected1.equals("Europe") && selected2.equals("UK men")) {
                result=String.format("%.2f", (numberForConvert-=33.5));
            } else if (selected1.equals("Europe") && selected2.equals("US women")) {
                result=String.format("%.2f", (numberForConvert-=30.5));
            } else if (selected1.equals("Europe") && selected2.equals("US men")) {
                result=String.format("%.2f", (numberForConvert-=33));
            } else if (selected1.equals("UK women") && selected2.equals("Europe")) {
                result=String.format("%.2f", (numberForConvert+=32.5));
            } else if (selected1.equals("UK women") && selected2.equals("US women")) {
                result=String.format("%.2f", (numberForConvert+=2));
            } else if (selected1.equals("UK women") && selected2.equals("US men")) {
                result=String.format("%.2f", (numberForConvert-=0.5));
            } else if (selected1.equals("UK women") && selected2.equals("UK men")) {
                result=String.format("%.2f", (numberForConvert-=1));
            } else if (selected1.equals("UK men") && selected2.equals("Europe")) {
                result=String.format("%.2f", (numberForConvert+=33.5));
            } else if (selected1.equals("UK men") && selected2.equals("US women")) {
                result=String.format("%.2f", (numberForConvert-=3));
            } else if (selected1.equals("UK men") && selected2.equals("US men")) {
                result=String.format("%.2f", (numberForConvert+=0.5));
            } else if (selected1.equals("UK men") && selected2.equals("UK women")) {
                result=String.format("%.2f", (numberForConvert+=1));
            } else if (selected1.equals("US women") && selected2.equals("Europe")) {
                result=String.format("%.2f", (numberForConvert+=30.5));
            } else if (selected1.equals("US women") && selected2.equals("UK women")) {
                result=String.format("%.2f", (numberForConvert-=2));
            } else if (selected1.equals("US women") && selected2.equals("UK men")) {
                result = String.format("%.2f", (numberForConvert += 3));
            } else if (selected1.equals("US women") && selected2.equals("US men")) {
                result = String.format("%.2f", (numberForConvert -= 2.5));
            } else if (selected1.equals("US men") && selected2.equals("Europe")) {
                result = String.format("%.2f", (numberForConvert += 33));
            } else if (selected1.equals("US men") && selected2.equals("UK women")) {
                result = String.format("%.2f", (numberForConvert += 0.5));
            } else if (selected1.equals("US men") && selected2.equals("UK men")) {
                result = String.format("%.2f", (numberForConvert -= 0.5));
            } else if (selected1.equals("US men") && selected2.equals("US women")) {
                result = String.format("%.2f", (numberForConvert += 2.5));
            }
        }
    }
}
