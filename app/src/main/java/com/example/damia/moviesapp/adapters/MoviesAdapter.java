package com.example.damia.moviesapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.damia.moviesapp.R;
import com.example.damia.moviesapp.activities.MovieActivity;
import com.example.damia.moviesapp.entities.Movie;

import java.util.List;

/**
 * Created by damia on 07.04.2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private List<Movie> mMovies;
    private Context mContext;

    public MoviesAdapter(Context context, List<Movie> movies){
        mMovies = movies;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView tvMovieTitle;
        public ImageView ivMoviePoster;

        public ViewHolder(View itemView){
            super(itemView);

            tvMovieTitle = itemView.findViewById(R.id.tv_movie_name);
            ivMoviePoster = itemView.findViewById(R.id.iv_movie_img);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view){
            int position = getAdapterPosition();
            if(position != RecyclerView.NO_POSITION){
                Movie movie = mMovies.get(position);
                MovieActivity.start(view.getContext(), movie);
            }
        }
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View movieView = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder viewHolder, int position){
        Movie movie = mMovies.get(position);
        TextView textView = viewHolder.tvMovieTitle;
        textView.setText(movie.getTitle());
        ImageView imageView = viewHolder.ivMoviePoster;
        imageView.setImageResource(movie.getMovieImgResource());
    }

    @Override
    public int getItemCount(){
        return mMovies.size();
    }

    public void onItemDismiss(int position){
        mMovies.remove(position);
        notifyItemRemoved(position);
    }
}
