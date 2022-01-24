package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class MotywActivity extends Activity  {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_motyw);
    }
    public void goBack(View view) {
        startActivity(new Intent(MotywActivity.this, UstawieniaActivity.class));
    }


    public void setThemeToLight(View view) {
        ConstraintLayout constLayout = findViewById(R.id.contLayout);
        constLayout.setBackgroundColor(Color.parseColor("#00ACC1"));
        TextView textView = findViewById(R.id.textView4);
        textView.setTextColor(Color.BLACK);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
    }

    public void setThemeToDark(View view) {
        ConstraintLayout constLayout = findViewById(R.id.contLayout);
        constLayout.setBackgroundColor(Color.BLACK);
        TextView textView = findViewById(R.id.textView4);
        textView.setTextColor(Color.WHITE);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }
}