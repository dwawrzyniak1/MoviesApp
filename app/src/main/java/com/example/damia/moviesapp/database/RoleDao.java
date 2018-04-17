package com.example.damia.moviesapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.damia.moviesapp.entities.Role;
import com.example.damia.moviesapp.entities.Movie;
import com.example.damia.moviesapp.entities.Person;

import java.util.List;

/**
 * Created by damia on 12.04.2018.
 */

@Dao
public interface RoleDao {

    @Insert
    void insert(Role... role);

    @Query("SELECT * FROM person INNER JOIN roles ON person.id=roles.actor_id WHERE roles.movie_id=:movieId")
    List<Person> getActorsFromMovie(final long movieId);

    @Query("SELECT * FROM movie INNER JOIN roles ON\n" +
            "           movie.id=roles.movie_id WHERE\n" +
            "           roles.actor_id=:actorId")
    List<Movie> getMovieByActorId(final long actorId);

    @Query("DELETE FROM roles")
    void deleteAllRoles();

    @Query("SELECT * FROM roles")
    List<Role> getAllRoles();
}
