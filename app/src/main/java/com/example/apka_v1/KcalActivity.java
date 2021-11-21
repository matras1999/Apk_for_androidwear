package com.example.apka_v1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.apka_v1.databinding.ActivityMainBinding;

public class KcalActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_kcal);
        GoBack();
    }
    private void GoBack(){
        ImageButton StartButton = (ImageButton) findViewById(R.id.BackButton);
        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KcalActivity.this, StartActivity.class));
            }
        });
    }
}
