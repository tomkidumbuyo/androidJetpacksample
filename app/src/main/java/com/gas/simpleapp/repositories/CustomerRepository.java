package com.gas.simpleapp.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.gas.simpleapp.dao.CustomerDao;
import com.gas.simpleapp.db.CustomerDatabase;
import com.gas.simpleapp.entity.Customers;

import java.util.List;

import androidx.room.Update;

public class CustomerRepository {

    private CustomerDao customerDao;
    private LiveData<List<Customers>> all;

    public CustomerRepository(Application application) {
        CustomerDatabase database = CustomerDatabase.getInstance(application);
        customerDao = database.customerDao();
        all = customerDao.getAll();
    }

    public void insert(Customers customer){
        new InsertCustomerAsynkTask(customerDao).execute(customer);
    }
    public void update(Customers customer){
        new UpdateCustomerAsynkTask(customerDao).execute(customer);
    }
    public void delete(Customers customer){
        new DeleteCustomerAsynkTask(customerDao).execute(customer);
    }

    public void deleteAll(){
        new DeleteAllCustomerAsynkTask(customerDao).execute();
    }
    public LiveData<List<Customers>> getAll(){
        return all;
    }

    private static class InsertCustomerAsynkTask extends AsyncTask<Customers,Void,Void>{
        private CustomerDao customerDao;

        private InsertCustomerAsynkTask(CustomerDao customerDao){
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customers... customers) {
            customerDao.insert(customers[0]);
            return null;
        }
    }

    private static class DeleteCustomerAsynkTask extends AsyncTask<Customers,Void,Void>{
        private CustomerDao customerDao;

        private DeleteCustomerAsynkTask(CustomerDao customerDao){
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customers... customers) {
            customerDao.delete(customers[0]);
            return null;
        }
    }

    private static class UpdateCustomerAsynkTask extends AsyncTask<Customers,Void,Void> {
        private CustomerDao customerDao;

        private UpdateCustomerAsynkTask(CustomerDao customerDao) {
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customers... customers) {
            customerDao.update(customers[0]);
            return null;
        }
    }

    private static class DeleteAllCustomerAsynkTask extends AsyncTask<Customers,Void,Void>{
        private CustomerDao customerDao;

        private DeleteAllCustomerAsynkTask(CustomerDao customerDao){
            this.customerDao = customerDao;
        }

        @Override
        protected Void doInBackground(Customers... customers) {
            customerDao.deleteAll();
            return null;
        }
    }
}
