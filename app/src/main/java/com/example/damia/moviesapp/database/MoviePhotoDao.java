package com.example.damia.moviesapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.damia.moviesapp.entities.MoviePhoto;

import java.util.List;

/**
 * Created by damia on 15.04.2018.
 */

@Dao
public interface MoviePhotoDao {

    @Insert
    void insert(MoviePhoto... moviePhotos);

    @Query("DELETE FROM movie_photos")
    void deleteAllMoviePhotos();

    @Query("SELECT photo_source FROM movie_photos WHERE movie_id=:movieId")
    List<Integer> findMoviePhotosByMovieId(long movieId);
}
