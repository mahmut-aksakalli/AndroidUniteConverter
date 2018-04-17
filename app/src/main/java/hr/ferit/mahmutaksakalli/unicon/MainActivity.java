package hr.ferit.mahmutaksakalli.unicon;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String OUTPUT_VALUE = "output_value";
    public static final String INPUT_VALUE  = "input_value";
    public static final String INPUT_TYPE  = "input_type";
    public static final String OUTPUT_TYPE  = "output_type";
    public static final String CONVERSION_ID  = "conversion_id";
    public static final String[] TEMPERATURE_UNITES = {"Celsius","Fahrenheit"};
    public static final String[] DISTANCE_UNITES = {"meters","kilometers","yards"};
    public static final String[] VOLUME_UNITES = {"liters","milliliters"};
    public static final String[] SPEED_UNITES = {"km/h","mph"};
    public static final String[] CONVERSION_TYPES = {"temperature","distance","volume","speed"};

    LinearLayout temperatureLayout, distanceLayout, volumeLayout, speedLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureLayout = (LinearLayout) findViewById(R.id.temperature);
        distanceLayout = (LinearLayout) findViewById(R.id.distance);
        volumeLayout = (LinearLayout) findViewById(R.id.volume);
        speedLayout = (LinearLayout) findViewById(R.id.speed);
        temperatureLayout.setOnClickListener(this);
        distanceLayout.setOnClickListener(this);
        volumeLayout.setOnClickListener(this);
        speedLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent mainIntent = new Intent();

        switch (v.getId())
        {
            case (R.id.temperature):
                mainIntent.setClass(getApplicationContext(),TemperatureActivity.class);
                startActivity(mainIntent);
                break;
            case (R.id.distance):
                mainIntent.setClass(getApplicationContext(),DistanceActivity.class);
                startActivity(mainIntent);
                break;
            case (R.id.volume):
                mainIntent.setClass(getApplicationContext(),VolumeActivity.class);
                startActivity(mainIntent);
                break;
            case (R.id.speed):
                mainIntent.setClass(getApplicationContext(),SpeedActivity.class);
                startActivity(mainIntent);
                break;
        }
    }
}

