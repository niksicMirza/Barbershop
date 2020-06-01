package com.example.myproject;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Customers.class,FeedbackDetails.class, PriceDetails.class, TeamDetails.class, ProductDetails.class},version =12, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FeedbackDao feedbackDao();
    public abstract PriceDao priceDao();
    public abstract CustomersDAO customersDAO();
    public abstract TeamDao teamDao();
    public abstract ProductDao productDao();
    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context,AppDatabase.class,"app_database").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
}
