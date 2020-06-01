package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class AdminCustomersActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_customers);
        listView=findViewById(R.id.list_view_container_customers_admin);
        setupListAdapter();
    }

    private void setupListAdapter() {
        List<Customers> customers = AppDatabase.getInstance(this).customersDAO().getAll();
         CustomersListAdapter customersListAdapter = new CustomersListAdapter(this, customers);
        listView.setAdapter(customersListAdapter);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
