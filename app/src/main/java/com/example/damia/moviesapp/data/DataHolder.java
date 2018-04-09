package com.example.damia.moviesapp.data;

import com.example.damia.moviesapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by damia on 09.04.2018.
 */

public class DataHolder {

    public static Map<Integer, Person> testActorsMap = createTestActorsMap();

    private static Map<Integer, Person> createTestActorsMap(){
        Map<Integer, Person> actors = new HashMap<>();
        actors.put(1, createPerson("Brad", "Pitt", "18/12/1963", R.drawable.bradpitt));
        actors.put(2, createPerson("Edward", "Norton", "18/8/1969", R.drawable.edwardnorton));
        actors.put(3, createPerson("Helena", "Bonham-Carter", "26/5/1966", R.drawable.helenabonhamcarter));
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

    public static List<Movie> getTestMoviesList(){
        List<Movie> movies = new ArrayList<>();
        Integer[] ids = {1,2,3};
        movies.add(new Movie("Fight club", R.drawable.fightclub, ids));
        movies.add(new Movie("Prestige", R.drawable.prestige));
        movies.add(new Movie("500 days of Summer", R.drawable.the500daysofsummer));
        movies.add(new Movie("Kiler", R.drawable.kiler));
        movies.add(new Movie("Pulp fiction", R.drawable.pulpfiction));
        movies.add(new Movie("The phantom thread", R.drawable.phantomthread));
        movies.add(new Movie("Dancer in the dark", R.drawable.dancerinthedark));
        return movies;
    }

}
