package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {
    public static final String EXTRA_FEEDBACK_ID = "FeedbackActivity/EXTRA_FEEDBACK_ID";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        listView=findViewById(R.id.list_view_container_feedback) ;
        setupListAdapter();

    }

    private void setupListAdapter() {
        List<FeedbackDetails> feedbackDetails = AppDatabase.getInstance(this).feedbackDao().getAll();
        FeedbackListAdapter feedbackListAdapter=new FeedbackListAdapter(this, feedbackDetails);
        listView.setAdapter(feedbackListAdapter);
    }
    public void onAddClick(View view){
        Intent intent = new Intent(this,AddFeedbackActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}

