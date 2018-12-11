package com.example.tantan.healthchecker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class DisplayResult extends AppCompatActivity {

    private String message ;
    private String color;
    private Double colorNumber;
    private Date date;
    private String heightInfo;
    private String weightInfo ;
    private String SwitchState ;
    Record record = new Record(heightInfo, weightInfo, colorNumber, date, SwitchState, message, color);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        // Get the Intent that started this activity and eget the string value of it
        Intent intent = getIntent();

         message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
         color = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
         colorNumber = Double.parseDouble(color);
         date = AppUtils.getCurrentDateTime();
        heightInfo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
         weightInfo = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        SwitchState = intent.getStringExtra(MainActivity.EXTRA_MESSAGE5);

        // Changes the color of the text depending on the BMI result
        TextView textView = findViewById(R.id.textView6);
        TextView textViewheight = findViewById(R.id.textView10);
        TextView textViewweight = findViewById(R.id.textView11);
        TextView textViewTime = findViewById(R.id.textView12);
        textViewTime.setText(TimestampConverter.dateToTimestamp(date));
        if (SwitchState.equals("on")) {
            textViewheight.setText(heightInfo + " " + "ft");
            textViewweight.setText(weightInfo + " " + "Lbs");
        } else if (SwitchState.equals("off")) {
            textViewheight.setText(heightInfo + " " + "cm");
            textViewweight.setText(weightInfo + " " + "kg");
        }

        if (colorNumber >= 25 && colorNumber < 30){
            textView.setTextColor(Color.parseColor("#1388aa"));
            textView.setText(message);
        }else if(colorNumber < 18.5 && colorNumber > 7.5){
            textView.setTextColor(Color.parseColor("#f5d342"));
            textView.setText(message);
        }else if (colorNumber >= 30 && colorNumber < 88.8){
            textView.setTextColor(Color.parseColor("#e64d62"));
            textView.setText(message);
        }else if (colorNumber > 88.8){
            textView.setTextColor(Color.parseColor("#60cdcb"));
            String MESSAGE = "Your Body Mass Index is too large. Please pick a proper height or weight.";
            textView.setText(MESSAGE);
        }  else if (colorNumber< 7.5){
            String MESSAGE = "Your Body Mass Index is too small. Please pick a proper height or weight.";
            textView.setText(MESSAGE);
        } else {
            textView.setTextColor(Color.parseColor("#60cdcb"));
            textView.setText(message);
        }
        updateRecord();
    }

    public void saveRecord(View view) {
        GlobalModel.getInstance().addRecord(this.record);
        Log.d("check123456", String.valueOf(record));
        finish();
    }

    public void updateRecord(){
        record.setBMI(colorNumber);
        record.setColor(color);
        record.setSaveAt(date);
        record.setWeight(weightInfo);
        record.setHeight(heightInfo);
        record.setEU(SwitchState);
        record.setMessage(message);
    }



}
