package com.example.myproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface CustomersDAO {

    @Insert
    void add(Customers customer);

    @Query("SELECT * FROM customers")
    List<Customers> getAll();

    @Query("SELECT * FROM customers WHERE id = :id LIMIT 1")
    Customers getCustomerById(long id);

    


}

