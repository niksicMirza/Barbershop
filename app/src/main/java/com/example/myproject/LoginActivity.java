package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_CUSTOMERS_ID = "LoginActivity/EXTRA_CUSTOMERS_ID";
    EditText username, password;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username_sign_in);
        password = findViewById(R.id.password_sign_in);
        signIn = findViewById(R.id.sign_in_button);
    }

    public void onSign(View view) {

        if(username.getText().toString().equals("") || password.getText().toString().equals("")) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        } else {

            List<Customers> customers = AppDatabase.getInstance(this).customersDAO().getAll();
            int k = 1;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getUsername().equals(username.getText().toString()) && customers.get(i).getPassword().equals(password.getText().toString())) {
                    k = 0;
                    Intent intent = new Intent(this, MainActivity.class);
                    int customerId = i + 1;
                    intent.putExtra(EXTRA_CUSTOMERS_ID, customerId);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                }
            }
            if (k == 1) {
                Toast.makeText(this, "Wrong Username or Password", Toast.LENGTH_LONG).show();
            }

            if (username.getText().toString().equals("admin")) {
                Intent intentR = new Intent(this, AdminActivity.class);
                startActivity(intentR);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

