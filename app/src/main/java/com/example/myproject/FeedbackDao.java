package com.example.myproject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FeedbackDao {
    @Insert
    void add(FeedbackDetails feedbackDetails);

    @Query("SELECT * FROM feedback")
    List<FeedbackDetails> getAll();

    @Query("SELECT * FROM feedback WHERE id = :id LIMIT 1")
    FeedbackDetails getFeedbackById(long id);

}


