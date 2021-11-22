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
    }

    public void goToStart(View view) {
        startActivity(new Intent(MenuActivity.this, StartActivity.class));
    }

    public void goToMain(View view) {
        startActivity(new Intent(MenuActivity.this, MainActivity.class));
    }

    public void goToSett(View view) {
        startActivity(new Intent(MenuActivity.this, UstawieniaActivity.class));
    }

    public void goToInfo(View view) {
        startActivity(new Intent(MenuActivity.this, InfoActivity.class));
    }
}
