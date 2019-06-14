package com.gas.simpleapp;


import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gas.simpleapp.entity.Customers;
import com.gas.simpleapp.viewmodals.CustomerViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CustomerViewModel customerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final CustomerAdapter adapter = new CustomerAdapter();
        recyclerView.setAdapter(adapter);

        customerViewModel = ViewModelProviders.of(this).get(CustomerViewModel.class);
        customerViewModel.getAll().observe(this, new Observer<List<Customers>>() {
            @Override
            public void onChanged(@Nullable List<Customers> customers) {
                Toast.makeText(MainActivity.this,"onChanged",Toast.LENGTH_SHORT).show();
                adapter.setCustomers(customers);
            }
        });

    }
}
