package com.example.damia.moviesapp.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by damia on 12.04.2018.
 */

@Entity(tableName = "roles",
        foreignKeys = {@ForeignKey(entity = Person.class, parentColumns = "id", childColumns = "actor_id", onDelete = CASCADE),
               @ForeignKey(entity = Movie.class, parentColumns = "id", childColumns = "movie_id", onDelete = CASCADE)},
        primaryKeys = {"actor_id", "movie_id"})
public class Role {

    @ColumnInfo(name = "actor_id")
    public long actorId;
    @ColumnInfo(name = "movie_id")
    public long movieId;

    public Role(long actorId, long movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", actorId=" + actorId +
                ", movieId=" + movieId +
                '}';
    }
}
