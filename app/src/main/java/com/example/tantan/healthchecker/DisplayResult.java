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
        String heightInfo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String weightInfo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        String SwitchState = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);

        // Changes the color of the text depending on the BMI result
        TextView textView = findViewById(R.id.textView6);
        TextView textViewheight = findViewById(R.id.textView10);
        TextView textViewweight = findViewById(R.id.textView11);
        if (SwitchState.equals("on")) {
            textViewheight.setText(heightInfo + " " + "ft");
            textViewweight.setText(weightInfo + " " + "Lbs");
        } else if (SwitchState.equals("off")) {
            textViewheight.setText(heightInfo + " " + "cm");
            textViewweight.setText(weightInfo + " " + "kg");
        }

        if (colortext >= 25 && colortext < 30){
            textView.setTextColor(Color.parseColor("#1388aa"));
            textView.setText(message);
        }else if(colortext < 18.5 && colortext > 7.5){
            textView.setTextColor(Color.parseColor("#f5d342"));
            textView.setText(message);
        }else if (colortext >= 30 && colortext < 88.8){
            textView.setTextColor(Color.parseColor("#e64d62"));
            textView.setText(message);
        }else if (colortext > 88.8){
            textView.setTextColor(Color.parseColor("#60cdcb"));
            String MESSAGE = "Your Body Mass Index is too large. Please pick a proper height or weight.";
            textView.setText(MESSAGE);
        }  else if (colortext < 7.5){
            String MESSAGE = "Your Body Mass Index is too small. Please pick a proper height or weight.";
            textView.setText(MESSAGE);
        } else {
            textView.setTextColor(Color.parseColor("#60cdcb"));
            textView.setText(message);
        }
    }
}
