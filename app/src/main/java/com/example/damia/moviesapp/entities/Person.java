package com.example.damia.moviesapp.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.GregorianCalendar;

import static java.util.Calendar.YEAR;

/**
 * Created by damia on 27.03.2018.
 */

@Entity
public class Person{

    @PrimaryKey(autoGenerate = true)
    private long id = 0;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "day_of_birth")
    private GregorianCalendar dayOfBirth;
    @ColumnInfo(name = "profile_image")
    private Integer imgResource;

    public Person(long id, String firstName, String lastName, GregorianCalendar dayOfBirth, Integer imgResource) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.imgResource = imgResource;
    }

    @Ignore
    public Person(String firstName, String lastName, GregorianCalendar dayOfBirth, Integer imgResource) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.imgResource = imgResource;
    }

    /*
    * GETTERS AND SETTERS
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GregorianCalendar getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(GregorianCalendar dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public Integer getImgResource() {
        return imgResource;
    }

    public void setImgResource(Integer imgResource) {
        this.imgResource = imgResource;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + (GregorianCalendar.getInstance().get(YEAR) - (dayOfBirth.get(YEAR))) +
                ", imgResource=" + imgResource +
                '}';
    }
}
