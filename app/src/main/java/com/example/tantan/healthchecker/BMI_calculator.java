package com.example.tantan.healthchecker;

/**
 * This class calculate BMI in KG unit
 */
public class BMI_calculator extends MainActivity {
    private double height;
    private double weight;
    private double result;

    /**
     * BMI Calculator Constructor
     * @param height
     * @param weight
     */
    public BMI_calculator (double height, double weight){
        this.height = height/100;
        this.weight = weight;
    }

    /**
     * Calculate BMI Function
     */
    public void calculate(){

        this.result = weight / (Math.pow(height, 2.0));
    }

    /**
     *  This method is use for detecting the color of the output string
     * @return Double
     */

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



    /**
     * Write message to user
     * @return String
     */
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