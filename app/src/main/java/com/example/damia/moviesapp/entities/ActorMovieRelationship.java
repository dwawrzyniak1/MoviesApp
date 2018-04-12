package com.example.damia.moviesapp.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

/**
 * Created by damia on 12.04.2018.
 */

@Entity(tableName = "actors_movies", indices = @Index(value = {"actor_id", "movie_id"}),
foreignKeys = {@ForeignKey(entity = Person.class, parentColumns = "id", childColumns = "actor_id"),
               @ForeignKey(entity = Movie.class, parentColumns = "id", childColumns = "movie_id")})
public class ActorMovieRelationship {

    @ColumnInfo(name = "actor_id")
    public long actorId;
    @ColumnInfo(name = "movie_id")
    public long movieId;
}
