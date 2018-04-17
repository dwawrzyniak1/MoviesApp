package com.example.damia.moviesapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.database.LocalDataSource;
import com.example.damia.moviesapp.entities.Movie;
import com.example.damia.moviesapp.fragments.FragmentActors;
import com.example.damia.moviesapp.fragments.FragmentPhotos;
import com.example.damia.moviesapp.fragments.ViewPagerAdapter;

public class MovieActivity extends AppCompatActivity {

    private final static String MOVIE_KEY = "current";

    private static Movie mMovie;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        initialize();
    }

    private void initialize() {
        setupFragmentsManagement();
        long movieId = getIntent().getLongExtra(MOVIE_KEY, 1);
        mMovie = new LocalDataSource(this).getMovieById(movieId);
        setupViewsWithMovieData();
    }

    private void setupFragmentsManagement() {
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentActors(), getString(R.string.staring_fragment_title));
        adapter.addFragment(new FragmentPhotos(), getString(R.string.gallery_fragment_title));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewsWithMovieData() {
        ImageView ivMainImage = findViewById(R.id.iv_movie_main);
        ivMainImage.setImageResource(mMovie.getPosterResource());
        TextView tvTitle = findViewById(R.id.tv_movie_title);
        TextView tvGenre = findViewById(R.id.tv_movie_genre);
        tvTitle.setText(mMovie.getTitle());
        tvGenre.setText(mMovie.getGenre());
    }

    public static void start(Context context, long movieId) {
        Intent starter = new Intent(context, MovieActivity.class);
        starter.putExtra(MOVIE_KEY, movieId);
        context.startActivity(starter);
    }

    public Movie getMovie(){
        return mMovie;
    }

}
