package com.example.tantan.healthchecker;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tantan.healthchecker.R;
import com.example.tantan.healthchecker.MainActivity;

public class DisplayResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        // Get the Intent that started this activity and eget the string value of it
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String color = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        Double colortext = Double.valueOf(color);

        // Changes the color of the text depending on the BMI result
        TextView textView = findViewById(R.id.textView6);
        if (colortext >= 25 && colortext < 30){
            textView.setTextColor(Color.parseColor("#1388aa"));
            textView.setText(message);
        }else if(colortext < 18.5){
            textView.setTextColor(Color.parseColor("#f5d342"));
            textView.setText(message);
        }else if (colortext >= 30){
            textView.setTextColor(Color.parseColor("#e64d62"));
            textView.setText(message);
        }else{
            textView.setTextColor(Color.parseColor("#60cdcb"));
            textView.setText(message);
        }
    }
}
