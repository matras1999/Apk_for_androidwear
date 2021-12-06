package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;

import com.example.apka_v1.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends Activity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setAppLocale("pl-rPL");
    }

    public void goToMenuPage(View view) {
        startActivity(new Intent(MainActivity.this, MenuActivity.class));
    }

    private void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));

        res.updateConfiguration(conf, dm);
    }
}