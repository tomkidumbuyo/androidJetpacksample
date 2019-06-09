package com.gas.simpleapp.db;

import android.content.Context;

import com.gas.simpleapp.dao.CustomerDao;
import com.gas.simpleapp.entity.Customers;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Customers.class},version = 1)
public abstract class CustomerDatabase extends RoomDatabase {
    private static CustomerDatabase instance;

    public abstract CustomerDao customerDao();

    public static synchronized CustomerDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    CustomerDatabase.class,"customers")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
