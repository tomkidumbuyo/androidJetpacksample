package com.gas.simpleapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gas.simpleapp.entity.Customers;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerHolder>{

    private List<Customers> customers = new ArrayList<>();

    @NonNull
    @Override
    public CustomerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_item,parent,false);
        return new CustomerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHolder holder, int position) {
        Customers currentCustomer = customers.get(position);
        holder.textViewPriority.setText(String.valueOf(position));
        holder.textViewTittle.setText(currentCustomer.getFirst_name()+' '+currentCustomer.getLast_name());
        holder.textViewDescription.setText(currentCustomer.getAdress()+'\n'+currentCustomer.getEmail());
    }

    @Override
    public int getItemCount() {
        return customers.size();
    }

    @Override
    public void onViewAttachedToWindow(@NonNull CustomerHolder holder) {
        super.onViewAttachedToWindow(holder);
    }

    public void setCustomers(List<Customers> customers){
        this.customers = customers;
        notifyDataSetChanged();

    }

    class CustomerHolder extends RecyclerView.ViewHolder{
        private TextView textViewTittle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public CustomerHolder(@NonNull View itemView) {
            super(itemView);
            textViewTittle = itemView.findViewById(R.id.text_view_tittle);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_number);
        }
    }
}
