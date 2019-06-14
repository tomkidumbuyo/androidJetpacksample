package com.gas.simpleapp.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.gas.simpleapp.dao.CustomerDao;
import com.gas.simpleapp.entity.Customers;

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

    private static Callback roomCallback = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private  CustomerDao customerDao;

        private PopulateDbAsyncTask(CustomerDatabase db){
            customerDao = db.customerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
