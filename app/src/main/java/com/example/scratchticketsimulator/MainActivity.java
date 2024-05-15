package com.example.scratchticketsimulator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.play_button);
        button.setOnClickListener(click -> {
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        });
    }
}