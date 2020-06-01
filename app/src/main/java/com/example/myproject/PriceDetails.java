package com.example.myproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "price")
public class PriceDetails {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private int price;


    public PriceDetails( String name, int price) {
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}