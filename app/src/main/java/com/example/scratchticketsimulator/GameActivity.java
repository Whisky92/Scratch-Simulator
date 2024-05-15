package com.example.scratchticketsimulator;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.anupkumarpanwar.scratchview.ScratchView;
import com.example.scratchticketsimulator.databinding.ActivityGameBinding;

import model.Image;

//source mentioned in activity_game.xml

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        double number = Math.random();

        ActivityGameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_game);
        String source = number > 0.5 ? "@drawable/clover" : "@drawable/cross";
        Image image = new Image(source);
        binding.setMyImage(image);

        ScratchView scratchView = findViewById(R.id.scratch_view);
        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                String result = number > 0.5 ? "You Won!" : "You Lost!";
                Toast.makeText(GameActivity.this, result, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                return;
            }
        });
    }
}