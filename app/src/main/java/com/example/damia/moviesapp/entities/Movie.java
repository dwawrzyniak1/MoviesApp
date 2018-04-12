package com.example.damia.moviesapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by damia on 07.04.2018.
 */

public class Movie implements Parcelable{

    private String mTitle;
    private static Map<String, Integer> mImgResourceMap = new HashMap<>();
    private HashSet<Integer> mActorsIds;
    private String mGenre;

    public Movie(String mTitle, String mGenre) {
        this.mTitle = mTitle;
        this.mGenre = mGenre;
        mActorsIds = new HashSet<>();
    }

    public Movie(String mTitle, String mGenre,  Integer imgResource){
        this(mTitle, mGenre);
        setMovieImgResource(imgResource);
    }

    public Movie(String title, String genre, HashSet<Integer> actors){
        mTitle = title;
        mGenre = genre;
        mActorsIds = actors;
    }

    public Movie(String title, String genre, Integer imgResource, Integer[] actorsId){
        this(title, genre, imgResource);
        for(Integer i : actorsId) mActorsIds.add(i);
    }



    public void addActor(Integer actorId){
        mActorsIds.add(actorId);
    }

    protected Movie(Parcel in){
        this(in.readString(), in.readString(), (HashSet)in.readSerializable());
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mTitle);
        out.writeString(mGenre);
        out.writeSerializable(mActorsIds);
    }

    public void setMovieImgResource(Integer imgResource){
        mImgResourceMap.put(mTitle, imgResource);
    }

    public Integer getMovieImgResource(){
        return mImgResourceMap.get(mTitle);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public HashSet<Integer> getActorsIds(){
        return mActorsIds;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }
}
