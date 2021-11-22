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
    }

    public void goBack(View view) {
        startActivity(new Intent(StartActivity.this, MenuActivity.class));
    }

    public void goMapa(View view) {
        startActivity(new Intent(StartActivity.this, MapsActivity.class));
    }

    public void goToKcal(View view) {
        startActivity(new Intent(StartActivity.this, KcalActivity.class));
    }

    public void goToZdrowie(View view) {
        startActivity(new Intent(StartActivity.this, ZdrowieActivity.class));
    }

}
