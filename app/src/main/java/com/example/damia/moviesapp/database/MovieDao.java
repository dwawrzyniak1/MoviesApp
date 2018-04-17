package com.example.damia.moviesapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.damia.moviesapp.entities.Movie;

import java.util.List;

/**
 * Created by damia on 12.04.2018.
 */

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Movie... movie);

    @Update
    void updateMovie(Movie... movie);

    @Delete
    void deleteMovie(Movie... movie);

    @Query("SELECT * FROM movie")
    List<Movie> loadAllMovie();

    @Query("SELECT * FROM movie WHERE id=:movieId")
    Movie findMovieById(long movieId);

    @Query("DELETE FROM movie")
    void deleteAllMovies();

    @Query("SELECT id FROM movie WHERE title=:title")
    long findIdByMovieTitle(String title);
}
