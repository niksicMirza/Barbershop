package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminAddProductActivity extends AppCompatActivity {
    EditText name, price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_product);
        name = findViewById(R.id.name_input_add_product);
        price=findViewById(R.id.price_input_add_product);

    }

    public void onSave(View view){
        if(name.getText().toString().equals("")) {
            Toast.makeText(this, " All fields are required", Toast.LENGTH_LONG).show();
        } else {
            ProductDetails productDetails = new ProductDetails(R.drawable.product, name.getText().toString(), Integer.parseInt(price.getText().toString()));
            AppDatabase.getInstance(this).productDao().add(productDetails);
            Intent intent = new Intent(this,AdminProductsActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

    public void onCancel(View view){
        Intent intent = new Intent(this,AdminProductsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
