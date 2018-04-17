package hr.ferit.mahmutaksakalli.unicon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent resultIntent = this.getIntent();

        int unite1 =  resultIntent.getIntExtra(MainActivity.INPUT_TYPE,0);
        int unite2 =  resultIntent.getIntExtra(MainActivity.OUTPUT_TYPE,0);
        float inputValue = resultIntent.getFloatExtra(MainActivity.INPUT_VALUE,0);
        float outputValue = resultIntent.getFloatExtra(MainActivity.OUTPUT_VALUE,0);
        String conversionType = resultIntent.getStringExtra(MainActivity.CONVERSION_ID);

        TextView unite1View = (TextView) findViewById(R.id.unite1);
        TextView unite2View = (TextView) findViewById(R.id.unite2);
        TextView inputValueView = (TextView) findViewById(R.id.inputValue);
        TextView outputValueView = (TextView) findViewById(R.id.outputValue);

        inputValueView.setText(String.valueOf(inputValue));
        outputValueView.setText(String.valueOf(outputValue));

        if (conversionType.equals(MainActivity.CONVERSION_TYPES[0])) {
            unite1View.setText(MainActivity.TEMPERATURE_UNITES[unite1]);
            unite2View.setText(MainActivity.TEMPERATURE_UNITES[unite2]);
        }
        else if(conversionType.equals(MainActivity.CONVERSION_TYPES[1])){
            unite1View.setText(MainActivity.DISTANCE_UNITES[unite1]);
            unite2View.setText(MainActivity.DISTANCE_UNITES[unite2]);

        }
        else if(conversionType.equals(MainActivity.CONVERSION_TYPES[2])){
            unite1View.setText(MainActivity.VOLUME_UNITES[unite1]);
            unite2View.setText(MainActivity.VOLUME_UNITES[unite2]);

        }
        else if(conversionType.equals(MainActivity.CONVERSION_TYPES[3])){
            unite1View.setText(MainActivity.SPEED_UNITES[unite1]);
            unite2View.setText(MainActivity.SPEED_UNITES[unite2]);
        }



    }
}
