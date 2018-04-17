package com.example.damia.moviesapp.database;

import android.content.Context;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.entities.Movie;
import com.example.damia.moviesapp.entities.MoviePhoto;
import com.example.damia.moviesapp.entities.Person;
import com.example.damia.moviesapp.entities.Role;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * Created by damia on 16.04.2018.
 */

public class DataInitializer {

    private static boolean initialized = false;

    public static void initialize(Context context){
        if(!initialized){
            mDataBase = AppDatabase.getAppDatabase(context);
            deleteAllData();
            setupAllData();
            initialized = true;
        }
    }

    private static void setupAllData() {
        setupTestMovieData();
        setupTestActorsData();
        setupTestMovieActorRelationship();
        setupMoviePhotos();
    }

    private static void deleteAllData() {
        mDataBase.roleDao().deleteAllRoles();
        mDataBase.personDao().deleteAllPeople();
        mDataBase.movieDao().deleteAllMovies();
        mDataBase.moviePhotoDao().deleteAllMoviePhotos();
    }

    private static AppDatabase mDataBase;

    private static void setupTestMovieData() {
        MovieDao dao = mDataBase.movieDao();
        dao.insertMovie(getTestMovieArray());
    }

    private static Movie[] getTestMovieArray() {
        Movie[] movies = new Movie[7];
        movies[0] = new Movie("Fight club", "Thriller", R.drawable.fightclub);
        movies[1] = new Movie("Prestige", "Thriller",R.drawable.prestige);
        movies[2] = new Movie("500 days of Summer","Drama", R.drawable.the500daysofsummer);
        movies[3] = new Movie("Seven","Detective", R.drawable.kiler);
        movies[4] = new Movie("Inception","Action", R.drawable.pulpfiction);
        movies[5] = new Movie("American Hustle","Crime", R.drawable.phantomthread);
        movies[6] = new Movie("Her","Drama", R.drawable.dancerinthedark);
        return movies;
    }

    private static void setupTestActorsData(){
        PersonDao dao = mDataBase.personDao();
        dao.insertPeople(getTestActorArray());
    }

    private static Person[] getTestActorArray() {
        Person[] actors = new Person[11];
        actors[0] = createPerson("Brad", "Pitt", "18/12/1963", R.drawable.bradpitt);
        actors[1] = createPerson("Edward", "Norton", "18/8/1969", R.drawable.edwardnorton);
        actors[2] = createPerson("Helena", "Bonham-Carter", "26/5/1966", R.drawable.helenabonhamcarter);
        actors[3] = createPerson("Joseph", "Gordon-Levitt", "17/2/1981", R.drawable.josephgordonlevitt);
        actors[4] = createPerson("Zooey", "Deschanel", "17/1/1980", R.drawable.zooeydeschanel);
        actors[5] = createPerson("Christian", "Bale", "30/1/1974", R.drawable.christianbale);
        actors[6] = createPerson("Leonardo", "DiCaprio", "11/11/1974", R.drawable.leonardodicaprio);
        actors[7] = createPerson("Morgan", "Freeman", "1/6/1937", R.drawable.morganfreeman);
        actors[8] = createPerson("Amy", "Adams", "20/8/1974", R.drawable.amyadams);
        actors[9] = createPerson("Scarlett", "Johansson", "22/11/1984", R.drawable.scarlettjohansson);
        actors[10] = createPerson("Joaquin", "Phoenix", "28/10/1974", R.drawable.joaquinphoenix);
        return actors;
    }

    private static Person createPerson(String firstName, String lastName, String date, Integer imgResource){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        try {
            gregorianCalendar.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Person(firstName, lastName, gregorianCalendar, imgResource);
    }

    private static void setupTestMovieActorRelationship(){
        mDataBase.roleDao().insert(getTestActorMovieRelationshipArray());
    }

    private static Role[] getTestActorMovieRelationshipArray() {
        Role[] relationships = new Role[16];
        relationships[0] = new Role(idOf("Brad", "Pitt"), idOf("Fight club"));
        relationships[1] = new Role(idOf("Edward", "Norton"), idOf("Fight club"));
        relationships[2] = new Role(idOf("Helena", "Bonham-Carter"), idOf("Fight club"));
        relationships[3] = new Role(idOf("Christian", "Bale"), idOf("Prestige"));
        relationships[4] = new Role(idOf("Scarlett", "Johansson"), idOf("Prestige"));
        relationships[5] = new Role(idOf("Joseph", "Gordon-Levitt"), idOf("500 days of Summer"));
        relationships[6] = new Role(idOf("Zooey", "Deschanel"), idOf("500 days of Summer"));
        relationships[7] = new Role(idOf("Brad", "Pitt"), idOf("Seven"));
        relationships[8] = new Role(idOf("Morgan", "Freeman"), idOf("Seven"));
        relationships[9] = new Role(idOf("Leonardo", "DiCaprio"), idOf("Inception"));
        relationships[10] = new Role(idOf("Joseph", "Gordon-Levitt"), idOf("Inception"));
        relationships[11] = new Role(idOf("Christian", "Bale"), idOf("American Hustle"));
        relationships[12] = new Role(idOf("Amy", "Adams"), idOf("American Hustle"));
        relationships[13] = new Role(idOf("Joaquin", "Phoenix"), idOf("Her"));
        relationships[14] = new Role(idOf("Amy", "Adams"), idOf("Her"));
        relationships[15] = new Role(idOf("Scarlett", "Johansson"), idOf("Her"));
        return relationships;
    }

    private static long idOf(String firstName, String lastName){
        return mDataBase.personDao().findPersonIdByFirstnameAndLastname(firstName, lastName);
    }

    private static long idOf(String title){
        return mDataBase.movieDao().findIdByMovieTitle(title);
    }

    private static void setupMoviePhotos(){
        mDataBase.moviePhotoDao().insert(getTestMoviePhotoArray());
    }

    private static MoviePhoto[] getTestMoviePhotoArray(){
        MoviePhoto[] photos = new MoviePhoto[16];
        photos[0] = new MoviePhoto(R.drawable.fightclubphoto1, idOf("Fight club"));
        photos[1] = new MoviePhoto(R.drawable.fightclubphoto2, idOf("Fight club"));
        photos[2] = new MoviePhoto(R.drawable.fightclubphoto3, idOf("Fight club"));
        photos[3] = new MoviePhoto(R.drawable.fightclubphoto4, idOf("Fight club"));
        photos[4] = new MoviePhoto(R.drawable.prestigephoto1, idOf("Prestige"));
        photos[5] = new MoviePhoto(R.drawable.prestigephoto2, idOf("Prestige"));
        photos[6] = new MoviePhoto(R.drawable.prestigephoto3, idOf("Prestige"));
        photos[7] = new MoviePhoto(R.drawable.prestigephoto4, idOf("Prestige"));
        photos[8] = new MoviePhoto(R.drawable.the500daysofsummerphoto1, idOf("500 days of Summer"));
        photos[9] = new MoviePhoto(R.drawable.the500daysofsummerphoto2, idOf("500 days of Summer"));
        photos[10] = new MoviePhoto(R.drawable.the500daysofsummerphoto3, idOf("500 days of Summer"));
        photos[11] = new MoviePhoto(R.drawable.the500daysofsummerphoto4, idOf("500 days of Summer"));
        photos[12] = new MoviePhoto(R.drawable.sevenphoto1, idOf("Seven"));
        photos[13] = new MoviePhoto(R.drawable.sevenphoto2, idOf("Seven"));
        photos[14] = new MoviePhoto(R.drawable.sevenphoto3, idOf("Seven"));
        photos[15] = new MoviePhoto(R.drawable.sevenphoto4, idOf("Seven"));
        return photos;
    }
}
