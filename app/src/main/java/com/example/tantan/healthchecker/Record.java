package com.example.tantan.healthchecker;

import java.util.Date;

/**
 * A lass contain user's info, time and variables to display the result
 */
public class Record {
    private String height;
    private String weight;
    private Double bmi;
    private Date saveAt;
    private String eu;
    private String message;
    private String color;

    /**
     * Record constructor
     * @param height
     * @param weight
     * @param bmi
     * @param saveAt
     * @param eu
     * @param message
     * @param color
     */
    public Record(String height, String weight, Double bmi, Date saveAt, String eu, String message, String color) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.eu = eu;
        this.saveAt = saveAt;
        this.message = message;
        this.color = color;
    }

    /**
     * Get a record's height
     * @return String
     */
    public String getHeight() {
        return height;
    }

    /**
     * Get a record's weight
     * @return String
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Get a record's BMI
     * @return Double
     */
    public Double getBMI() {
        return bmi;
    }

    /**
     * Get time of record
     * @return Date
     */
    public Date getSaveAt() {
        return saveAt;
    }

    /**
     * Get the message to user
     * @return String
     */
    public String getMessage() {return message;}

    /**
     * Get the mode of unit, "on" = kg and "off" = Lbl
     * @return
     */
    public String getEU() {
        return eu;
    }

    /**
     * Get the color of text
     * @return String
     */
    public String getColor() {return color;}

    /**
     * Set record height
     * @param height
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Set record weight
     * @param weight
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * Set record BMI
     * @param BMI
     */
    public void setBMI(Double BMI) {
        this.bmi = BMI;
    }

    /**
     * Set record time
     * @param saveAt
     */
    public void setSaveAt(Date saveAt) {
        this.saveAt = saveAt;
    }

    /**
     * Set mode of unit
     * @param eu
     */
    public void setEU( String eu) {
        this.eu = eu;
    }

    /**
     * Set messafe of record
     * @param message
     */
    public void  setMessage (String message) {this.message = message;}

    /**
     * Return Date to display on listview
     * @return
     */
    public String toString() {
        return TimestampConverter.dateToTimestamp(saveAt);
    }

    /**
     * Set color of message
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }
}
