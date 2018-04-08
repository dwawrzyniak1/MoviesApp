package com.example.damia.moviesapp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by damia on 27.03.2018.
 */

@Entity
public class Person implements Parcelable{

    public static Map<Integer, Person> testActorsMap = createTestActorsMap();

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "first_name")
    private String firstName;
    @ColumnInfo(name = "last_name")
    private String lastName;
    @ColumnInfo(name = "day_of_birth")
    private GregorianCalendar dayOfBirth;

    public Person(String firstName, String lastName, GregorianCalendar dayOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
    }

    public static void addPerson(final AppDatabase db, Person person){
        db.personDao().insertPeople(person);
    }

    private static void populateWithTestData(AppDatabase db){
        GregorianCalendar dateOfBirth = new GregorianCalendar();
        dateOfBirth.set(1963, 12, 18);
        Person person = new Person("Brad", "Pitt", dateOfBirth);
        addPerson(db, person);
        dateOfBirth.set(1969, 8, 18);
        person = new Person("Edward", "Norton", dateOfBirth);
        addPerson(db, person);
        dateOfBirth.set(1966, 5, 26);
        person = new Person("Helena", "Bonham-Carter", dateOfBirth);
        addPerson(db, person);
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

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public GregorianCalendar getDayOfBirth() {
        return dayOfBirth;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDayOfBirth(GregorianCalendar dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    private static Map<Integer, Person> createTestActorsMap(){
        Map<Integer, Person> actors = new HashMap<>();
        actors.put(1, createPerson("Brad", "Pitt", 1963, 12, 18));
        actors.put(2, createPerson("Edward", "Norton", 1969, 8, 18));
        actors.put(3, createPerson("Helena", "Bonham-Carter", 1966, 5, 26));
        return actors;
    }

    private static Person createPerson(String firstName, String lastName, int year, int month, int day){
        GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, day);
        return new Person(firstName, lastName, gregorianCalendar);
    }
}
