package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class ZdrowieActivity extends Activity implements SensorEventListener {

    private static final String TAG = "MainActivity";
    private TextView mTextViewHeart;
    SensorManager mSensorManager;
    Sensor mHeartRateSensor;
    SensorEventListener sensorEventListener;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_zdrowie);

        mTextViewHeart = (TextView) findViewById(R.id.textView);
        mSensorManager = ((SensorManager) getSystemService(SENSOR_SERVICE));
        mHeartRateSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        mSensorManager.registerListener(this, mHeartRateSensor, SensorManager.SENSOR_DELAY_NORMAL);

        mTextViewHeart.setText("Something here");


        mSensorManager.registerListener(this, mHeartRateSensor, mSensorManager.SENSOR_DELAY_FASTEST);

    }

    public void onResume(){
        super.onResume();
    }


    public void goBack(View view) {
        startActivity(new Intent(ZdrowieActivity.this, StartActivity.class));
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
                System.out.println("coś");
        if (sensorEvent.sensor.getType() == Sensor.TYPE_HEART_RATE) {
            String msg = "" + (int)sensorEvent.values[0];
            mTextViewHeart.setText(msg);
            System.out.println(TAG + msg);
        }
        else{
            System.out.println(TAG +  "Unknown sensor type");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        System.out.println(TAG + "onAccuracyChanged - accuracy: " + i);
    }
}
