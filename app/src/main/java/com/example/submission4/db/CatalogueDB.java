package com.example.submission4.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.submission4.models.MoviesData;
import com.example.submission4.models.TVShowsData;

@Database(entities = {MoviesData.class, TVShowsData.class}, version = 1, exportSchema = false)
public abstract class CatalogueDB extends RoomDatabase {

    public abstract DataAccessObject dataAccessObject();
}
