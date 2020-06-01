package com.example.myproject;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "feedback")
public class FeedbackDetails {
    @PrimaryKey(autoGenerate = true)
    private long id;
    String name;
    String message;



    public FeedbackDetails(String name, String message) {
        this.name = name;
        this.message = message;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
