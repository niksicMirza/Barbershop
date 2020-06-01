package com.example.myproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void add(ProductDetails productDetails);

    @Query("SELECT * FROM products")
    List<ProductDetails> getAll();

    @Query("SELECT * FROM products WHERE id = :id LIMIT 1")
    ProductDetails getProductById(long id);

    @Query("SELECT * FROM products WHERE title LIKE '%' || :name || '%'")
    List<ProductDetails> getProductByName(String name);

}
