package com.example.tantan.healthchecker.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.tantan.healthchecker.Record;

import java.util.List;

@Dao
public interface DaoAccess {
    @Insert
    long insertRecord(Record record);

    @Query("SELECT * FROM record_table ORDER BY saved_at desc")
    LiveData<List<Record>> fetchAllRecords();


    @Query("SELECT * FROM record_table WHERE recordID =:recordId")
    LiveData<Record> getRecord(int recordId);


    @Update
    void updateTask(Record record);


    @Delete
    void deleteTask(Record record);
}
