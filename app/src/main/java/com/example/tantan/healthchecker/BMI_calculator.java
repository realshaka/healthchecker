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
    // this method is use for detecting the color of the output string
    public double getCalculations(){
        if (result >= 25 && result < 30){
            return this.result;
        }else if(result < 18.5){
            return this.result;
        }else if (result >= 30){
            return  this.result;
        }else{
           return this.result;
        }
    }

    public String getResult(){
        if (result >= 25 && result < 30){
            return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is in the overweight range.";
        } else if (result < 18.5){
            return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is in the underweight range.";
        } else if (result >= 30){
           return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is in the obese range.";
        } else{
            return "Your Body Mass Index is " + String.format("%.1f",this.result) + "." + " This is in the normal range.";
        }
    }
}