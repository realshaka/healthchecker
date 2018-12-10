package com.example.tantan.healthchecker;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.example.tantan.healthchecker.ulti.DateConverter;

import java.io.Serializable;
import java.util.Date;

@Entity(tableName = "record_table")
public class Record implements Serializable {
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "recordID")
    private int id;

    @NonNull
    @ColumnInfo(name = "saved_at")
    @TypeConverters({DateConverter.class})
    private Date savedAt;

    private String height;
    private String weight;
    private Double BMI;

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Date getSavedAt() {
        return savedAt;
    }

    public void setSavedAt(Date savedAt) {
        this.savedAt = savedAt;
    }
}
