package hr.ferit.kristinajavorek.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConvertTimeAndShoes extends AppCompatActivity implements View.OnClickListener {
    EditText etMailInput;
    Button bProcess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_convert_time_and_shoes);
        this.setUpUI();
    }
    private void setUpUI() {
        this.etMailInput = (EditText) findViewById(R.id.etMailInput);
        this.bProcess = (Button) findViewById(R.id.bProcess);
        this.bProcess.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String email = this.etMailInput.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainActivity.KEY_SHOES, email);
        this.setResult(RESULT_OK, resultIntent);
        this.finish();
    }
}
