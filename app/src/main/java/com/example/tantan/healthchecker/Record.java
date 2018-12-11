package com.example.tantan.healthchecker;

import java.util.Date;

public class Record {
    private String height;
    private String weight;
    private Double bmi;
    private Date saveAt;
    private String eu;
    private String message;
    private String color;
    public Record(String height, String weight, Double bmi, Date saveAt, String eu, String message, String color) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.eu = eu;
        this.saveAt = saveAt;
        this.message = message;
        this.color = color;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public Double getBMI() {
        return bmi;
    }

    public Date getSaveAt() {
        return saveAt;
    }

    public String getMessage() {return message;}

    public String getEU() {
        return eu;
    }
    public String getColor() {return color;}

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setBMI(Double BMI) {
        this.bmi = BMI;
    }

    public void setSaveAt(Date saveAt) {
        this.saveAt = saveAt;
    }

    public void setEU( String eu) {
        this.eu = eu;
    }

    public void  setMessage (String message) {this.message = message;}

    public String toString() {
        return TimestampConverter.dateToTimestamp(saveAt);
    }

    public void setColor(String color) {
        this.color = color;
    }
}
