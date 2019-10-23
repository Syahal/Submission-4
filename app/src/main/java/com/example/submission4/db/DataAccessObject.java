package com.example.submission4.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.submission4.models.MoviesData;
import com.example.submission4.models.TVShowsData;

import java.util.List;

@Dao
interface DataAccessObject {
    @Insert void insertFavoriteMovie(MoviesData moviesData);
    @Query("SELECT * FROM MoviesData")
    List<MoviesData> getFavoriteMovie();

    @Insert void insertFavoriteTVShow(TVShowsData tvShowsData);
    @Query("SELECT * FROM TVShowsData")
    List<TVShowsData> getFavoriteTVShow();
}
