package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class StartActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_start);
        GoBack();
        GoMapa();
        GoToKcal();
        GoToZdrowie();
    }
    private void GoBack(){
        ImageButton StartButton = (ImageButton) findViewById(R.id.BackButton);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, MenuActivity.class));
            }
        });
    }

    private void GoMapa() {
        ImageButton MapaButton = (ImageButton) findViewById(R.id.MapaButton);
        MapaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, MapsActivity.class));
            }
        });
    }
        private void GoToKcal(){
            Button KcalButton = (Button) findViewById(R.id.KcalButton);
            KcalButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(StartActivity.this, KcalActivity.class));
                }
            });
    }
    private void GoToZdrowie(){
        Button ZdrowieButton = (Button) findViewById(R.id.ZdrowieButton);
        ZdrowieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, ZdrowieActivity.class));
            }
        });
    }
}
