package com.example.damia.moviesapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.damia.moviesapp.entities.Person;

import java.util.List;

/**
 * Created by damia on 12.04.2018.
 */

@Dao
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPeople(Person[] people);

    @Update
    void updatePeople(Person... people);

    @Delete
    void deletePeople(Person... people);

    @Query("SELECT * FROM person")
    List<Person> loadAllPeople();

    @Query("DELETE FROM person")
    void deleteAllPeople();

    @Query("SELECT id FROM person WHERE person.first_name=:firstName AND person.last_name=:lastName")
    long findPersonIdByFirstnameAndLastname(String firstName, String lastName);

}
