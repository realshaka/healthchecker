package com.example.tantan.healthchecker;

import java.util.ArrayList;

public class GlobalModel {
    private static final GlobalModel ourInstance = new GlobalModel();

    private ArrayList<Record> records;

    static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        records = new ArrayList<Record>();

    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public Record getRecord(int i) {

        return records.get(i);
    }

    public void addRecord(Record record) {
        records.add(record);
    }



}
