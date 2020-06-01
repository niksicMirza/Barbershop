package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        listView=findViewById(R.id.list_view_container_products);
        setupListAdapter();
    }

    private void setupListAdapter() {
        List<ProductDetails> productDetails = AppDatabase.getInstance(this).productDao().getAll();
        ProductListAdapter productListAdapter = new ProductListAdapter(productDetails, this);
        listView.setAdapter(productListAdapter);
    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
