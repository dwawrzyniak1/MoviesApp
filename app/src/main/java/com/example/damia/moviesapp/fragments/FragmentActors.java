package com.example.damia.moviesapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.activities.MovieActivity;
import com.example.damia.moviesapp.adapters.PeopleAdapter;
import com.example.damia.moviesapp.database.LocalDataSource;
import com.example.damia.moviesapp.entities.Movie;
import com.example.damia.moviesapp.entities.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damia on 08.04.2018.
 */

public class FragmentActors extends Fragment {

    private ListView mListView;
    private PeopleAdapter mAdapter;
    private Activity mParent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        View view = inflater.inflate(R.layout.people_fragment, container, false);
        mListView = view.findViewById(R.id.lv_people);
        mListView.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParent = getActivity();
        mAdapter = new PeopleAdapter(mParent.getApplicationContext(), getActorsArraylist());
    }

    private ArrayList<Person> getActorsArraylist() {
        ArrayList<Person> people = new ArrayList<>();
        Movie movie = ((MovieActivity)mParent).getMovie();
        LocalDataSource localDataSource = new LocalDataSource(mParent.getApplicationContext());
        people.addAll(localDataSource.getActorsFromMovie(movie.getId()));
        return people;
    }
}
