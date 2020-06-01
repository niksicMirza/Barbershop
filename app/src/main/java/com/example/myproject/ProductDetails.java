package com.example.myproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products")
public class ProductDetails {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private int imageResId;
    private String title;
    private int price;

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }




    public ProductDetails(int imageResId, String title,int price) {
        this.imageResId = imageResId;
        this.title = title;
        this.price = price;
    }
}
