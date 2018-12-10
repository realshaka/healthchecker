package com.example.tantan.healthchecker.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.tantan.healthchecker.Record;
import com.example.tantan.healthchecker.dao.DaoAccess;

@Database(entities = {Record.class}, version = 1, exportSchema = false)
public abstract class RecordDatabase extends RoomDatabase {

    public abstract DaoAccess daoAccess();
}

