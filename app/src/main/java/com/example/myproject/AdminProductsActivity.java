package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AdminProductsActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_products);
        listView=findViewById(R.id.list_view_container_products_admin);
        setupListAdapter();

    }

    private void setupListAdapter() {
        List<ProductDetails> productDetails = AppDatabase.getInstance(this).productDao().getAll();
        ProductListAdapter productListAdapter = new ProductListAdapter(productDetails, this);
        listView.setAdapter(productListAdapter);
    }

    public void onAddClick(View view){
        Intent intent = new Intent(this,AdminAddProductActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}
