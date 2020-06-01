package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AdminAddPriceActivity extends AppCompatActivity {
    TextView name, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_price);
        name = findViewById(R.id.name_input_add_price);
        price = findViewById(R.id.price_input_add_price);

    }

    public void onSave(View view){
        if(name.getText().toString().equals("") || price.getText().toString().equals("")) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        } else {
            PriceDetails priceDetails = new PriceDetails(name.getText().toString(),Integer.parseInt(price.getText().toString()));
            AppDatabase.getInstance(this).priceDao().add(priceDetails);
            Intent intent = new Intent(this,AdminPricingActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

    public void onCancel(View view){
        Intent intent = new Intent(this,AdminPricingActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

