package com.example.damia.moviesapp.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.damia.moviesapp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by damia on 07.04.2018.
 */

public class Movie implements Parcelable{

    private String mTitle;
    private static Map<String, Integer> mImgResourceMap = new HashMap<>();
    private HashSet<Integer> mActorsIds;

    public Movie(String mTitle) {
        this.mTitle = mTitle;
        mActorsIds = new HashSet<>();
    }

    public Movie(String mTitle, Integer imgResource){
        this(mTitle);
        setMovieImgResource(imgResource);
    }

    public Movie(String title, HashSet<Integer> actors){
        mTitle = title;
        mActorsIds = actors;
    }

    public Movie(String title, Integer imgResource, Integer[] actorsId){
        this(title, imgResource);
        for(Integer i : actorsId) mActorsIds.add(i);
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

    public static List<Movie> getTestMoviesList(){
        List<Movie> movies = new ArrayList<>();
        Integer[] ids = {1,2,3};
        movies.add(new Movie("Fight club", R.drawable.fightclub, ids));
        movies.add(new Movie("Prestige", R.drawable.prestige));
        movies.add(new Movie("500 days of Summer", R.drawable.the500daysofsummer));
        movies.add(new Movie("Kiler", R.drawable.kiler));
        movies.add(new Movie("Pulp fiction", R.drawable.pulpfiction));
        movies.add(new Movie("The phantom thread", R.drawable.phantomthread));
        movies.add(new Movie("Dancer in the dark", R.drawable.dancerinthedark));
        return movies;
    }

    public void addActor(Integer actorId){
        mActorsIds.add(actorId);
    }

    protected Movie(Parcel in){
        this(in.readString(), (HashSet)in.readSerializable());
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
        out.writeSerializable(mActorsIds);
    }
}
