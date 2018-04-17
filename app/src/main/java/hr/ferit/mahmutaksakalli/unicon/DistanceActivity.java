package hr.ferit.mahmutaksakalli.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DistanceActivity extends AppCompatActivity implements View.OnClickListener{
    public ArrayAdapter<String> distanceAdapter;
    public Spinner distanceSpinner1, distanceSpinner2;
    public Button convertButton;
    public EditText uniteValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        convertButton = (Button) findViewById(R.id.convertButton);
        convertButton.setOnClickListener(this);

        uniteValue = (EditText) findViewById(R.id.uniteValue);

        distanceAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, MainActivity.DISTANCE_UNITES);
        distanceSpinner1 = (Spinner) findViewById(R.id.inputValue);
        distanceSpinner2 = (Spinner) findViewById(R.id.unite2);

        distanceSpinner1.setAdapter(distanceAdapter);
        distanceSpinner2.setAdapter(distanceAdapter);
    }

    @Override
    public void onClick(View v){
        int unite1 = distanceSpinner1.getSelectedItemPosition();
        int unite2 = distanceSpinner2.getSelectedItemPosition();
        float inputValue = Float.valueOf(uniteValue.getText().toString());
        float outputValue = 0;

        if ( unite1 == 0){
            if(unite2 == 0){
                outputValue = inputValue;
            }
            else if(unite2 == 1){
                outputValue = Converter.convertMetersToKilometers(inputValue);
            }
            else if(unite2 == 2){
                outputValue = (float)Converter.convertMetersToYards(inputValue);

            }
        }
        else if(unite1 == 1){
            if(unite2 == 1){
                outputValue = inputValue;
            }
            else if(unite2 == 0){
                outputValue = Converter.convertKilometersToMeters(inputValue);
            }
            else if(unite2 == 2){
                outputValue = Converter.convertKilometersToMeters(inputValue);
                outputValue = (float)Converter.convertMetersToYards(outputValue);
            }
        }
        else if(unite1 == 2){
            if(unite2 == 2){
                outputValue = inputValue;
            }
            else if(unite2 == 0){
                outputValue = (float)Converter.convertYardToMeters(inputValue);
            }
            else if(unite2 == 1){
                outputValue = (float)Converter.convertYardToMeters(inputValue);
                outputValue = Converter.convertMetersToKilometers(outputValue);
            }
        }

        Intent resultIntent = new Intent(getApplicationContext(),ResultActivity.class);
        resultIntent.putExtra(MainActivity.INPUT_VALUE,inputValue);
        resultIntent.putExtra(MainActivity.OUTPUT_VALUE,outputValue);
        resultIntent.putExtra(MainActivity.INPUT_TYPE,unite1);
        resultIntent.putExtra(MainActivity.OUTPUT_TYPE,unite2);
        resultIntent.putExtra(MainActivity.CONVERSION_ID,MainActivity.CONVERSION_TYPES[1]);
        startActivity(resultIntent);

    }

    public void onEditTextClick(View View){
        uniteValue.setText("");
    }
}
