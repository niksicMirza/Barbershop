package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PricingActivity extends AppCompatActivity {
    private ListView listView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricing);
        listView = findViewById(R.id.list_view_container_pricing);
        setupListAdapter();


    }

    private void setupListAdapter() {
        List<PriceDetails> priceDetails = AppDatabase.getInstance(this).priceDao().getAll();
        PricingListAdapter pricingListAdapter = new PricingListAdapter(this, priceDetails);
        listView.setAdapter(pricingListAdapter);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}