package com.example.tantan.healthchecker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class ShowRecordDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record_details);


        Bundle bundle = getIntent().getExtras();
        int i = bundle.getInt(RecordsActivity.EXTRA, 0);
        Log.d("nextActivity", "printTextView" + GlobalModel.getInstance().getRecord(i).getSaveAt());

        String message = GlobalModel.getInstance().getRecord(i).getMessage();
        String color = GlobalModel.getInstance().getRecord(i).getColor();
        Double colortext = Double.valueOf(color);
        Date date = AppUtils.getCurrentDateTime();
        String heightInfo = GlobalModel.getInstance().getRecord(i).getHeight();
        String weightInfo = GlobalModel.getInstance().getRecord(i).getWeight();;
        String SwitchState = (GlobalModel.getInstance().getRecord(i).getEU());

        // Changes the color of the text depending on the BMI result
        TextView textView = findViewById(R.id.textView6);
        TextView textViewheight = findViewById(R.id.textView10);
        TextView textViewweight = findViewById(R.id.textView11);
        TextView textViewTime = findViewById(R.id.textView12);
        textViewTime.setText(TimestampConverter.dateToTimestamp(GlobalModel.getInstance().getRecord(i).getSaveAt()));
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

        Log.d("check9999", String.valueOf(GlobalModel.getInstance().getRecord(i)));
    }


}
