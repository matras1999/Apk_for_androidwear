package com.example.apka_v1;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class StepsActivity extends Activity implements SensorEventListener {
    private ActivityMainBinding binding;
    private TextView textViewStepCounter, textViewStepDetector;
    private SensorManager sensorManager;
    private Sensor mStepCounter;
    private boolean isCounterSensorPresent;
    int stepCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_steps);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter = findViewById(R.id.textViewStepCounter);
        //textViewStepDetector = findViewById(R.id.textViewStepDetector);

        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);




        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        }
        else{
            textViewStepCounter.setText("Counter Sensor jest nie użyty");
            isCounterSensorPresent = false;
        }
    }


    public void goBack(View view) {
        startActivity(new Intent(StepsActivity.this, StartActivity.class));
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == mStepCounter) {
            stepCount = (int) sensorEvent.values[0];
            textViewStepCounter.setText(String.valueOf(stepCount));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.registerListener(this, mStepCounter, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.unregisterListener(this, mStepCounter);
        }
    }
}
