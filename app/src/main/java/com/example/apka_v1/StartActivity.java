package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class StartActivity extends Activity {
    private ActivityMainBinding binding;
    Chronometer chronometer;
    ImageButton buttonStart,butttonStop;

    private boolean isResume;
    Handler handler;
    long tMilliSec,tStart,tBuff,tUpdate = 0L;
    int sec,min,milliSec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_start);

        chronometer = findViewById(R.id.stoper);
        buttonStart = findViewById(R.id.start);
        butttonStop = findViewById(R.id.stop);

       handler = new Handler();
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isResume){
                    tStart=SystemClock.uptimeMillis();
                    handler.postDelayed(runnable,0);
                    chronometer.start();
                    isResume=true;
                    butttonStop.setVisibility(View.GONE);
                    buttonStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_pause));
                }
                else{
                    tBuff+=tMilliSec;
                    handler.removeCallbacks(runnable);
                    chronometer.stop();
                    isResume=false;
                    butttonStop.setVisibility(View.VISIBLE);
                    buttonStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_play));
                }
            }
        });

        butttonStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(!isResume){
                    buttonStart.setImageDrawable(getResources().getDrawable(
                            R.drawable.ic_play
                    ));
                 tMilliSec = 0L;
                 tStart = 0L;
                 tBuff = 0L;
                 tUpdate = 0L;
                 sec = 0;
                 min= 0 ;
                 milliSec= 0 ;
                chronometer.setText("00:00:00");
                }
            }
        });

    }
    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            tMilliSec = SystemClock.uptimeMillis() - tStart;
            tUpdate = tBuff+tMilliSec;
            sec = (int)(tUpdate/1000);
            min = sec/60;
            sec = sec%60;
            milliSec = (int)(tUpdate%100);
            chronometer.setText(String.format("%02d",min)+":"+String.format("%02d",sec)+":"+String.format("%02d",milliSec));
            handler.postDelayed(this,60);
        }
    };

    public void goBack(View view) {
        startActivity(new Intent(StartActivity.this, MenuActivity.class));
    }

    public void goMapa(View view) {
        startActivity(new Intent(StartActivity.this, MapsActivity.class));
    }

    public void goToKcal(View view) {
        startActivity(new Intent(StartActivity.this, StepsActivity.class));
    }

    public void goToZdrowie(View view) {
        startActivity(new Intent(StartActivity.this, ZdrowieActivity.class));
    }


}
