package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.apka_v1.databinding.ActivityMainBinding;

import java.util.Locale;

public class JezykActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_jezyk);
    }

    public void goBack(View view) {
        startActivity(new Intent(JezykActivity.this, UstawieniaActivity.class));
    }

    private void setAppLocale(String localeCode){
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale(localeCode.toLowerCase()));

        res.updateConfiguration(conf, dm);
    }

    public void changeOnPolish(View view) {
        setAppLocale("pl-rPL");
        finish();
        startActivity(getIntent());
    }


    public void changeOnEnglish(View view) {
        setAppLocale("en");
        finish();
        startActivity(getIntent());
    }
}