package com.gas.simpleapp.dao;

import android.arch.lifecycle.LiveData;

import com.gas.simpleapp.entity.Customers;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CustomerDao {

    @Insert
    void insert(Customers customer);

    @Update
    void update(Customers customer);

    @Delete
    void delete(Customers customer);

    @Query("DELETE FROM customers")
    void deleteAll();

    @Query("SELECT * FROM customers ORDER BY id DESC")
    LiveData<List<Customers>> getAll();

}
