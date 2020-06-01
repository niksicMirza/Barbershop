package com.example.myproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomersListAdapter extends BaseAdapter {
    private Context context;
    private List<Customers> customersList;

    public CustomersListAdapter(Context context, List<Customers> customers) {
        this.context = context;
        this.customersList = customers;
    }

    @Override
    public int getCount() {
        return customersList.size();
    }

    @Override
    public Object getItem(int position) {
        return customersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return customersList.indexOf(customersList.get(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        convertView=inflater.inflate(R.layout.customers_item,parent,false);

        Customers customers=customersList.get(position);

        ImageView imageView = convertView.findViewById(R.id.item_image_customer);
        TextView titleTextView = convertView.findViewById(R.id.item_name_customer);
        TextView phoneNumber = convertView.findViewById(R.id.item_phone_number_customer);

        imageView.setImageResource(customers.getImageResId());
        titleTextView.setText(customers.getName());
        phoneNumber.setText(customers.getPhone());

        return convertView;
    }
}