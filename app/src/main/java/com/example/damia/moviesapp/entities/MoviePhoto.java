package com.example.damia.moviesapp.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by damia on 12.04.2018.
 */

@Entity(tableName = "movie_photos", foreignKeys = @ForeignKey(entity = Movie.class, parentColumns = "id", childColumns = "movie_id"))
public class MoviePhoto {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "photo_source")
    private int photoSource;

    @ColumnInfo(name = "movie_id")
    private long movieId;

    public MoviePhoto(int photoSource, long movieId) {
        this.photoSource = photoSource;
        this.movieId = movieId;
    }

    public int getPhotoSource() {
        return photoSource;
    }

    public void setPhotoSource(int photoSource) {
        this.photoSource = photoSource;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
