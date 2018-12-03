package com.example.tantan.healthchecker;

import android.content.Intent;

import com.example.tantan.healthchecker.MainActivity;

public class BMI_calculator extends MainActivity {
    private double height;
    private double weight;
    private double result;

    public BMI_calculator (double height, double weight){
        this.height = height/100;
        this.weight = weight;
    }

    public void calculate(){
        this.result = weight / (Math.pow(height, 2.0));
    }

    public String getResult(){
        if (result >= 25.0){
            return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is considered overweight.";
        } else if (result < 18.5){
            return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is considered underweight.";
        } else {
            return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is considered normal.";
        }
    }
}