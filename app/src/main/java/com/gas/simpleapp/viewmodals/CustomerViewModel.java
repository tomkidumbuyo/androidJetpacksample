package com.gas.simpleapp.viewmodals;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.gas.simpleapp.entity.Customers;
import com.gas.simpleapp.repositories.CustomerRepository;

import java.util.List;


public class CustomerViewModel extends AndroidViewModel {

    private CustomerRepository repository;
    private LiveData<List<Customers>> all;

    public CustomerViewModel(@NonNull Application application){
        super(application);
        repository = new CustomerRepository(application);
        all = repository.getAll();
    }

    public void insert(Customers customer){
        repository.insert(customer);
    }

    public void update(Customers customer){
        repository.update(customer);
    }

    public void delete(Customers customer){
        repository.delete(customer);
    }

    public void deleteAll(){
        repository.deleteAll();
    }

    public LiveData<List<Customers>> getAll(){
        return  all;
    }
}
