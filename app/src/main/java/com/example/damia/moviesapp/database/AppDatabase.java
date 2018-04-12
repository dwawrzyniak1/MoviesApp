package com.example.damia.moviesapp.database;

/**
 * Created by damia on 12.04.2018.
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.example.damia.moviesapp.entities.ActorMovieRelationship;
import com.example.damia.moviesapp.entities.Movie;
import com.example.damia.moviesapp.entities.MoviePhoto;
import com.example.damia.moviesapp.entities.Person;

@Database(entities = {Person.class, Movie.class, MoviePhoto.class, ActorMovieRelationship.class}, version = 1)
@TypeConverters({PersonConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public abstract PersonDao personDao();

    public static AppDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "movieapp-database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }
}
