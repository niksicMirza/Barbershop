package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    EditText name, username, password, phone, passwordConf, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.register_name);
        username=findViewById(R.id.register_username);
        password=findViewById(R.id.register_password);
        phone=findViewById(R.id.register_phone);
        email=findViewById(R.id.register_email);
    }


        public void onReg(View view){
         int j=0;
        String username_check = username.getText().toString();
        List<Customers> customers = AppDatabase.getInstance(this).customersDAO().getAll();
        for(int i = 0; i < customers.size();i++){
            if(customers.get(i).getUsername().equals(username_check)){
                j=j+1;
            }
        }
        if(j==0){
            Customers customer = new Customers(R.drawable.avatar, name.getText().toString(),phone.getText().toString(),email.getText().toString(),username.getText().toString(), password.getText().toString());
            AppDatabase.getInstance(this).customersDAO().add(customer);
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);

        }else{ Toast.makeText(this,"Username already exists",Toast.LENGTH_LONG).show();  }

        }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


    }
