package com.gas.simpleapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.gas.simpleapp.entity.Customers;
import com.gas.simpleapp.viewmodals.CustomerViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomerViewModel customerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel.class);
        customerViewModel.getAll().observe(this, new Observer<List<Customers>>() {
            @Override
            public void onChanged(@Nullable List<Customers> customers) {
                Toast.makeText(MainActivity.this,"onChanged",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
