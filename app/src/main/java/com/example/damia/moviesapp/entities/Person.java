package com.example.damia.moviesapp.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.GregorianCalendar;

/**
 * Created by damia on 27.03.2018.
 */


public class Person implements Parcelable{

    private String firstName;
    private String lastName;
    private GregorianCalendar dayOfBirth;
    private Integer imgResource;

    public Person(String firstName, String lastName, GregorianCalendar dayOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
    }

    public Person(String firstName, String lastName, GregorianCalendar dayOfBirth, Integer imgResource) {
        this(firstName, lastName, dayOfBirth);
        this.imgResource = imgResource;
    }

    protected Person(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        dayOfBirth = (GregorianCalendar)in.readSerializable();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(firstName);
        out.writeString(lastName);
        out.writeSerializable(dayOfBirth);
    }

    /*
    * GETTERS AND SETTERS
     */

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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }


}
