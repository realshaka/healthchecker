package com.example.tantan.healthchecker;

import java.util.ArrayList;

/**
 * Singleton applied to fetch single list record to activities
 */
public class GlobalModel {
    private static final GlobalModel ourInstance = new GlobalModel();

    private ArrayList<Record> records;

    /**
     * Global model
     * @return Instance
     */
    static GlobalModel getInstance() {
        return ourInstance;
    }

    private GlobalModel() {
        records = new ArrayList<Record>();
    }

    /**
     * Return records list
     * @return ArrayList
     */
    public ArrayList<Record> getRecords() {
        return records;
    }

    /**
     * Get specific record by id
     * @param i
     * @return Record class
     */
    public Record getRecord(int i) {

        return records.get(i);
    }

    /**
     * Add new record to data list
     * @param record
     */
    public void addRecord(Record record) {
        records.add(record);
    }






}
