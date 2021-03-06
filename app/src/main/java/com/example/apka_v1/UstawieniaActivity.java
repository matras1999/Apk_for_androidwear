package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class UstawieniaActivity extends Activity {
    private ActivityMainBinding binding;
    private Object UstawieniaActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_ustawienia);
    }

    public void goBack(View view) {
        startActivity(new Intent(UstawieniaActivity.this, MenuActivity.class));
    }

    public void goWyborJezyka(View view) {
        startActivity(new Intent(UstawieniaActivity.this, JezykActivity.class));
    }

    public void goWyborMotywu(View view) {
        startActivity(new Intent(UstawieniaActivity.this, MotywActivity.class));
    }
    public void goPowiadomienia(View view) {
        startActivity(new Intent(UstawieniaActivity.this, PowiadomieniaAcivity.class));
    }
}
