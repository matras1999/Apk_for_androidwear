package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class MenuActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.wejdz_menu);

    GoToStart();
    GoToMain();
    GoToSett();
    GoToInfo();
    }
    private void GoToStart(){
        ImageButton StartButton = (ImageButton) findViewById(R.id.StartButton);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, StartActivity.class));
            }
        });
    }

    private void GoToMain(){
        ImageButton BackButton = (ImageButton) findViewById(R.id.BackButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MainActivity.class));
            }
        });
    }

    private void GoToSett(){
        ImageButton SettingsButton = (ImageButton) findViewById(R.id.SettingsButton);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, UstawieniaActivity.class));
            }
        });
    }

    private void GoToInfo(){
        ImageButton InfoButton = (ImageButton) findViewById(R.id.InfoButton);
        InfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, InfoActivity.class));
            }
        });
    }
}
