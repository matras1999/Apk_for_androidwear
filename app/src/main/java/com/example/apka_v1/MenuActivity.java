package com.example.apka_v1;

import android.app.Activity;
import android.os.Bundle;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class MenuActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.wejdz_menu);



    }
}
