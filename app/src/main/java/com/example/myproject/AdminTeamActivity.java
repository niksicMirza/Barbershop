package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class AdminTeamActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_team);
        listView=findViewById(R.id.list_view_container_admin_team);
        setupListAdapter();

    }

    private void setupListAdapter() {
        List<TeamDetails> teamDetails = AppDatabase.getInstance(this).teamDao().getAll();
        TeamListAdapter teamListAdapter = new TeamListAdapter(teamDetails, this);
        listView.setAdapter(teamListAdapter);
    }

    public void onAddClick(View view){
        Intent intent = new Intent(this,AdminAddBarberActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

}

