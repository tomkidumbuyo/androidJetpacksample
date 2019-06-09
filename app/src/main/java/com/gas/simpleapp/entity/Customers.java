package com.gas.simpleapp.entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "customers")
public class Customers {
    @PrimaryKey(autoGenerate = true)
    private String id;

    private String first_name;

    private String last_name;

    @Ignore()
    private String full_name;

    private String adress;

    private String phone_number;

    private String email;

    public Customers(String first_name, String last_name, String adress, String phone_number, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.adress = adress;
        this.phone_number = phone_number;
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getFull_name() {
        this.full_name = this.first_name+" "+this.last_name;
        return full_name;
    }
}
