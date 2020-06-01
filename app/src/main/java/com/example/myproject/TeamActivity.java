package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import java.util.List;

public class TeamActivity extends AppCompatActivity  {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        listView=findViewById(R.id.list_view_container_team);
        setupListAdapter();
    }



    private void setupListAdapter() {
        List<TeamDetails> teamDetails = AppDatabase.getInstance(this).teamDao().getAll();
        TeamListAdapter teamListAdapter = new TeamListAdapter(teamDetails, this);
        listView.setAdapter(teamListAdapter);
    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

