package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AdminAddBarberActivity extends AppCompatActivity {
    EditText name, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_barber);
        name = findViewById(R.id.input_name_add_barber);
        phone=findViewById(R.id.phone_input_add_barber);

    }

    public void onSave(View view){
        if(name.getText().toString().equals("")) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_LONG).show();
        } else {
            TeamDetails teamDetails = new TeamDetails(R.drawable.avatar_barber, name.getText().toString(), phone.getText().toString());
            AppDatabase.getInstance(this).teamDao().add(teamDetails);
            Intent intent = new Intent(this,AdminTeamActivity.class);
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