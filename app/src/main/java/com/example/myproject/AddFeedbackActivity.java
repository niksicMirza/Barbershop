package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddFeedbackActivity extends AppCompatActivity {
    TextView name, feedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);
        name = findViewById(R.id.name_input_add_feedback);
        feedback = findViewById(R.id.feedback_input);

    }

    public void onSave(View view){
        if(name.getText().toString().equals("") || feedback.getText().toString().equals("")) {
            Toast.makeText(this, " All fields are required", Toast.LENGTH_LONG).show();
        } else {
            FeedbackDetails feedbackDetails = new FeedbackDetails(name.getText().toString(),feedback.getText().toString());
            AppDatabase.getInstance(this).feedbackDao().add(feedbackDetails);
            Intent intent = new Intent(this,FeedbackActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

    public void onCancel(View view){
        Intent intent = new Intent(this,FeedbackActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

