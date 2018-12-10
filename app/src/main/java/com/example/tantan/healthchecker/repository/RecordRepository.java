package com.example.tantan.healthchecker.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.tantan.healthchecker.Record;
import com.example.tantan.healthchecker.db.RecordDatabase;
import com.example.tantan.healthchecker.ulti.AppUtils;

import java.util.List;

public class RecordRepository {
    private String DB_NAME = "db_record";
    private RecordDatabase recordDatabase;

    public RecordRepository (Context context) {
        recordDatabase = Room.databaseBuilder(context, RecordDatabase.class, DB_NAME).build();
    }

    public void insertRecord(String height, String weight, Double BMI) {
        Record record = new Record();
        record.setHeight(height);
        record.setWeight(weight);
        record.setSavedAt(AppUtils.getCurrentDateTime());
        insertRecord(record);
    }

    public void insertRecord(final Record record) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                recordDatabase.daoAccess().insertRecord(record);
                return null;
            }
        }.execute();
    }

    public LiveData<Record> getRecord(int id) {
        return recordDatabase.daoAccess().getRecord(id);
    }

    public LiveData<List<Record>> getRecords() {
        return recordDatabase.daoAccess().fetchAllRecords();
    }
}