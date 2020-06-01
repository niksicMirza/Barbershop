package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AdminPricingActivity extends AppCompatActivity {
    public static final String EXTRA_ADMIN_PRICING_ID = "AdminPricingActivity/EXTRA_ADMIN_PRICING_ID";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_pricing);
        listView=findViewById(R.id.list_view_container_admin_pricing);
        setupListAdapter();

    }

    private void setupListAdapter() {
        List<PriceDetails> priceDetails = AppDatabase.getInstance(this).priceDao().getAll();
        PricingListAdapter pricingListAdapter = new PricingListAdapter(this, priceDetails);
        listView.setAdapter(pricingListAdapter);
    }

    public void onAddClick(View view){
        Intent intent = new Intent(this,AdminAddPriceActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}



