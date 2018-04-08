package com.example.damia.moviesapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by damia on 08.04.2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentsList = new ArrayList<>();
    private final List<String> mListTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mListTitles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitles.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        mFragmentsList.add(fragment);
        mListTitles.add(title);
    }
}
