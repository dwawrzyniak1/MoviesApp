package com.example.damia.moviesapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Created by damia on 27.03.2018.
 */

@Dao
public interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPeople(Person... people);

    @Update
    void updatePeople(Person... people);

    @Delete
    void deletePeople(Person... people);

    @Query("SELECT * FROM person")
    Person[] loadAllPeople();

}
