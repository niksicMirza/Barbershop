package com.example.myproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PriceDao {
    @Insert
    void add(PriceDetails priceDetails);

    @Query("SELECT * FROM price")
    List<PriceDetails> getAll();

    @Query("SELECT * FROM price WHERE id = :id LIMIT 1")
    PriceDetails getPriceById(long id);

}