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

public class ConvertDistanceAndWeight extends AppCompatActivity implements View.OnClickListener{
    TextView tvConvert;
    Button bConvert;
    EditText etConvert;
    Spinner spinner1, spinner2;
    String[] spinner;
    ArrayAdapter<String> adapter;
    String inputData, selected1, selected2, result;
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
        if(startingIntent.hasExtra(MainActivity.KEY_DISTANCE)){
            inputData = startingIntent.getStringExtra(MainActivity.KEY_DISTANCE);
            tvConvert.setText(inputData+" CONVERTER");
            spinner = res.getStringArray(R.array.spinnerDistance);
        }
        if(startingIntent.hasExtra(MainActivity.KEY_WEIGHT)){
            inputData = startingIntent.getStringExtra(MainActivity.KEY_WEIGHT);
            tvConvert.setText(inputData +" CONVERTER");
            spinner = res.getStringArray(R.array.spinnerWeight);
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinner);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
    }
    @Override
    public void onClick(View view) {
        if(etConvert.getText().toString().matches("")){
            Toast.makeText(this, "You did not enter a value", Toast.LENGTH_SHORT).show();
        }else {
            selected1 = spinner1.getSelectedItem().toString();
            selected2 = spinner2.getSelectedItem().toString();
            numberForConvert = Double.parseDouble(etConvert.getText().toString());
            convert();
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        }
    }
    public void convert(){
        if(inputData.equals("DISTANCE")) {
            if (selected1 == selected2) {
                result = numberForConvert.toString();
            } else if (selected1.equals("Miles") && selected2.equals("Kilometers")) {
                result = (numberForConvert*=1.609344).toString();
            } else if (selected1.equals("Miles") && selected2.equals("Yards")) {
                result = (numberForConvert*=1760).toString();
            } else if (selected1.equals("Kilometers") && selected2.equals("Miles")) {
                result = (numberForConvert*=0.621371192).toString();
            } else if (selected1.equals("Kilometers") && selected2.equals("Yards")) {
                result = (numberForConvert*=1093.6133).toString();
            } else if (selected1.equals("Yards") && selected2.equals("Miles")) {
                result = (numberForConvert*=0.000568181818).toString();
            } else if (selected1.equals("Yards") && selected2.equals("Kilometers")) {
                result = (numberForConvert*=0.0009144).toString();
            }
        }
        if(inputData.equals("WEIGHT")) {
            if (selected1 == selected2) {
                result = numberForConvert.toString();
            } else if (selected1.equals("Kilograms") && selected2.equals("Pounds")) {
                result = (numberForConvert*=2.20462262).toString();
            } else if (selected1.equals("Kilograms") && selected2.equals("Decagrams")) {
                result = (numberForConvert*=100).toString();
            } else if (selected1.equals("Pounds") && selected2.equals("Kilograms")) {
                result = (numberForConvert*=0.45359237).toString();
            } else if (selected1.equals("Pounds") && selected2.equals("Decagrams")) {
                result = (numberForConvert*=45.359237).toString();
            } else if (selected1.equals("Decagrams") && selected2.equals("Pounds")) {
                result = (numberForConvert*=0.0220462262).toString();
            } else if (selected1.equals("Decagrams") && selected2.equals("Kilograms")) {
                result = (numberForConvert*=0.01).toString();
            }
        }
    }
}
