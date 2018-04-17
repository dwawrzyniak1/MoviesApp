package com.example.damia.moviesapp.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


/**
 * Created by damia on 07.04.2018.
 */
@Entity
public class Movie{

    @PrimaryKey(autoGenerate = true)
    private long id = 0;
    @ColumnInfo(name="title")
    private String title;
    @ColumnInfo(name="genre")
    private String genre;
    @ColumnInfo(name="poster_src")
    private Integer posterResource;

    public Movie(long id, String title, String genre, Integer posterResource) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.posterResource = posterResource;
    }

    @Ignore
    public Movie(String title, String genre, Integer posterResource) {
        this.title = title;
        this.genre = genre;
        this.posterResource = posterResource;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String mGenre) {
        this.genre = mGenre;
    }

    public void setPosterResource(Integer imgResource){
        posterResource = imgResource;
    }

    public Integer getPosterResource(){
        return posterResource;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", posterResource=" + posterResource +
                '}';
    }
}
