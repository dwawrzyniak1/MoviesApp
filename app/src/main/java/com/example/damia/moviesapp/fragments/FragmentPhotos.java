package com.example.damia.moviesapp.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.activities.MovieActivity;
import com.example.damia.moviesapp.adapters.ImageAdapter;
import com.example.damia.moviesapp.database.LocalDataSource;
import com.example.damia.moviesapp.entities.Movie;

import java.util.List;

/**
 * Created by damia on 08.04.2018.
 */

public class FragmentPhotos extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        view = inflater.inflate(R.layout.photos_fragment, container, false);
        setupGridView();
        return view;
    }

    private void setupGridView() {
        GridView gridView = view.findViewById(R.id.gridview);
        List<Integer> photosResources = getMoviePhotosResources();
        ImageAdapter adapter = new ImageAdapter(getContext(),photosResources);
        gridView.setAdapter(adapter);
    }

    private List<Integer> getMoviePhotosResources() {
        Activity parent = getActivity();
        LocalDataSource localDataSource = new LocalDataSource(parent.getApplicationContext());
        long movieId = ((MovieActivity)parent).getMovie().getId();
        return localDataSource.getPhotoResourceFromMovie(movieId);
    }

}
