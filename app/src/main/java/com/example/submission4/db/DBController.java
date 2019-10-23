package com.example.submission4.db;

import android.app.Application;

import androidx.room.Room;

public class DBController extends Application {

    public static CatalogueDB catalogueDB;

    @Override
    public void onCreate() {
        super.onCreate();
        catalogueDB = Room.databaseBuilder(getApplicationContext(), CatalogueDB.class, "catalogue_movie_database")
                .allowMainThreadQueries()
                .build();
    }
}
