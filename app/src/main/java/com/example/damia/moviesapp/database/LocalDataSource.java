package com.example.damia.moviesapp.database;

import android.content.Context;

import com.example.damia.moviesapp.entities.Role;
import com.example.damia.moviesapp.entities.Movie;
import com.example.damia.moviesapp.entities.Person;

import java.util.List;

/**
 * Created by damia on 12.04.2018.
 */

public class LocalDataSource {

    private static AppDatabase mDataBase;

    public LocalDataSource(Context mContext) {
        mDataBase = AppDatabase.getAppDatabase(mContext);
    }

    public List<Movie> getAllMovies(){
        return mDataBase.movieDao().loadAllMovie();
    }

    public List<Person> getAllActors(){
        return mDataBase.personDao().loadAllPeople();
    }

    public List<Role> getAllRoles(){return mDataBase.roleDao().getAllRoles();}

    public List<Person> getActorsFromMovie(long movieId){
        return mDataBase.roleDao().getActorsFromMovie(movieId);
    }

    public List<Integer> getPhotoResourceFromMovie(long movieId){
        return mDataBase.moviePhotoDao().findMoviePhotosByMovieId(movieId);
    }

    public Movie getMovieById(long movieId){
        return mDataBase.movieDao().findMovieById(movieId);
    }

}
