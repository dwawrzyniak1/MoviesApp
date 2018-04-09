package com.example.damia.moviesapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.adapters.MoviesAdapter;
import com.example.damia.moviesapp.adapters.PeopleAdapter;
import com.example.damia.moviesapp.data.DataHolder;
import com.example.damia.moviesapp.data.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Movie> mMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMovies = DataHolder.getTestMoviesList();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MoviesAdapter(this, mMovies);
        mRecyclerView.setAdapter(mAdapter);
    }


}
