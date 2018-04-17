package hr.ferit.mahmutaksakalli.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SpeedActivity extends AppCompatActivity implements View.OnClickListener{
    public ArrayAdapter<String> speedAdapter;
    public Spinner speedSpinner1, speedSpinner2;
    public Button convertButton;
    public EditText uniteValue;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setOnClickListener(this);

        uniteValue = (EditText) findViewById(R.id.uniteValue);

        speedAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, MainActivity.SPEED_UNITES);
        speedSpinner1 = (Spinner) findViewById(R.id.inputValue);
        speedSpinner2 = (Spinner) findViewById(R.id.unite2);

        speedSpinner1.setAdapter(speedAdapter);
        speedSpinner2.setAdapter(speedAdapter);
    }

    @Override
    public void onClick(View v){
        int unite1 = speedSpinner1.getSelectedItemPosition();
        int unite2 = speedSpinner2.getSelectedItemPosition();
        float inputValue = Float.valueOf(uniteValue.getText().toString());
        float outputValue = 0;

        if ( unite1 == 0){
            if(unite2 == 0){
                outputValue = inputValue;
            }
            else if(unite2 == 1){
                outputValue = Converter.convertKmhToMph(inputValue);
            }
        }
        else if(unite1 == 1){
            if(unite2 == 1){
                outputValue = inputValue;
            }
            else if(unite2 == 0){
                outputValue = (float)Converter.convertMphToKmh(inputValue);
            }
        }

        Intent resultIntent = new Intent(getApplicationContext(),ResultActivity.class);
        resultIntent.putExtra(MainActivity.INPUT_VALUE,inputValue);
        resultIntent.putExtra(MainActivity.OUTPUT_VALUE,outputValue);
        resultIntent.putExtra(MainActivity.INPUT_TYPE,unite1);
        resultIntent.putExtra(MainActivity.OUTPUT_TYPE,unite2);
        resultIntent.putExtra(MainActivity.CONVERSION_ID,MainActivity.CONVERSION_TYPES[3]);
        startActivity(resultIntent);

    }

    public void onEditTextClick(View View){
        uniteValue.setText("");
    }   
}
