package com.gas.simpleapp.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.gas.simpleapp.entity.Customers;

import java.util.List;

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
