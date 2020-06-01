package com.example.myproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TeamDao {

    @Insert
    void add(TeamDetails teamDetails);

    @Query("SELECT * FROM barber")
    List<TeamDetails> getAll();

    @Query("SELECT * FROM barber WHERE id = :id LIMIT 1")
    TeamDetails getBarberById(long id);

}
