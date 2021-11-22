package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class MainActivity extends Activity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }

    public void goToMenuPage(View view) {
        startActivity(new Intent(MainActivity.this, MenuActivity.class));
    }
}