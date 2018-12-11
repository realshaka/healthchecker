package com.example.tantan.healthchecker;

/**
 * This class calculate BMI in Lbl unit
 */
public class BMI_calculator_Imperial {
    private double height;
    private double weight;
    private double result;

    /**
     * BMI calculator in lbl unit
     * @param height
     * @param weight
     */
    public BMI_calculator_Imperial(double height, double weight){
        this.height = (height * 12);
        this.weight = (weight* 703);
    }

    /**
     * Calculate BMI function
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
