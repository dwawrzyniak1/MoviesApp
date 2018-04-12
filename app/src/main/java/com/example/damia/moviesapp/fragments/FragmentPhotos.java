package com.example.damia.moviesapp.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.adapters.ImageAdapter;

/**
 * Created by damia on 08.04.2018.
 */

public class FragmentPhotos extends Fragment {

    View view;
    private GridView gridView;
    private ImageAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstaceState){
        view = inflater.inflate(R.layout.photos_fragment, container, false);
        initializeViews();
        return view;
    }

    private void initializeViews() {
        gridView = view.findViewById(R.id.gridview);
        adapter = new ImageAdapter(getContext());
        gridView.setAdapter(adapter);
    }


}
