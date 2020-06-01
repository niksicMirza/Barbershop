package com.example.myproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "barber")
public class TeamDetails {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int imageResId;
    private String name;
    private String phone_number;



    public TeamDetails(int imageResId, String name, String phone_number) {
        this.imageResId = imageResId;
        this.name = name;
        this.phone_number=phone_number;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

}
