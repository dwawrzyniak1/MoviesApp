package com.example.damia.moviesapp.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by damia on 07.04.2018.
 */
@Entity
public class Movie implements Parcelable{

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String mTitle;
    private String mGenre;
    private Integer mPosterResource;

    public Movie(String mTitle, String mGenre, Integer mPosterResource) {
        this.mTitle = mTitle;
        this.mGenre = mGenre;
        this.mPosterResource = mPosterResource;
    }

    protected Movie(Parcel in){
        mTitle = in.readString();
        mGenre = in.readString();
        mPosterResource = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mTitle);
        out.writeString(mGenre);
        out.writeInt(mPosterResource);
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public void setPosterResource(Integer imgResource){
        mPosterResource = imgResource;
    }

    public Integer getPosterResource(){
        return mPosterResource;
    }

}
