package hr.ferit.mahmutaksakalli.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class VolumeActivity extends AppCompatActivity implements View.OnClickListener {

    public ArrayAdapter<String> volumeAdapter;
    public  Spinner  volumeSpinner1, volumeSpinner2;
    public Button convertButton;
    public EditText uniteValue;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);

        convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setOnClickListener(this);

        uniteValue = (EditText) findViewById(R.id.uniteValue);

        volumeAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, MainActivity.VOLUME_UNITES);
        volumeSpinner1 = (Spinner) findViewById(R.id.inputValue);
        volumeSpinner2 = (Spinner) findViewById(R.id.unite2);

        volumeSpinner1.setAdapter(volumeAdapter);
        volumeSpinner2.setAdapter(volumeAdapter);
    }

    @Override
    public void onClick(View v){
        int unite1 = volumeSpinner1.getSelectedItemPosition();
        int unite2 = volumeSpinner2.getSelectedItemPosition();
        float inputValue = Float.valueOf(uniteValue.getText().toString());
        float outputValue = 0;

        if ( unite1 == 0){
            if(unite2 == 0){
                outputValue = inputValue;
            }
            else if(unite2 == 1){
                outputValue = Converter.convertLitersToMilliliters(inputValue);
            }
        }
        else if(unite1 == 1){
            if(unite2 == 1){
                outputValue = inputValue;
            }
            else if(unite2 == 0){
                outputValue = Converter.convertMillilitersToLiters(inputValue);
            }
        }

        Intent resultIntent = new Intent(getApplicationContext(),ResultActivity.class);
        resultIntent.putExtra(MainActivity.INPUT_VALUE,inputValue);
        resultIntent.putExtra(MainActivity.OUTPUT_VALUE,outputValue);
        resultIntent.putExtra(MainActivity.INPUT_TYPE,unite1);
        resultIntent.putExtra(MainActivity.OUTPUT_TYPE,unite2);
        resultIntent.putExtra(MainActivity.CONVERSION_ID,MainActivity.CONVERSION_TYPES[2]);
        startActivity(resultIntent);

    }

    public void onEditTextClick(View View){
        uniteValue.setText("");
    }
}
