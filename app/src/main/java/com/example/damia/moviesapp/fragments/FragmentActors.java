package com.example.damia.moviesapp.fragments;

import android.app.Activity;
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
import com.example.damia.moviesapp.data.DataHolder;
import com.example.damia.moviesapp.data.Movie;
import com.example.damia.moviesapp.data.Person;

import java.util.ArrayList;

/**
 * Created by damia on 08.04.2018.
 */

public class FragmentActors extends Fragment {

    private ListView mListView;
    private PeopleAdapter mAdapter;
    private ArrayList<Person> mPeople;
    private Activity mParent;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        view = inflater.inflate(R.layout.people_fragment, container, false);
        initializeViews();
        return view;
    }

    private void initializeViews() {
        mListView = view.findViewById(R.id.lv_people);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeOnCreate();
    }

    private void initializeOnCreate() {
        mParent = getActivity();
        System.out.println(getView());
        mPeople = new ArrayList<>();
        fillPeopleArrayList();
        mAdapter = new PeopleAdapter(mParent.getApplicationContext(), mPeople);
    }

    private void fillPeopleArrayList() {
        Movie movie = ((MovieActivity)mParent).getMovie();
        for(Integer id : movie.getActorsIds()) mPeople.add(DataHolder.testActorsMap.get(id));
    }
}
