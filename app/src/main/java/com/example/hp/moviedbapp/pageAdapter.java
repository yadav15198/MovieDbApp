package com.example.hp.moviedbapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class pageAdapter extends FragmentPagerAdapter {
    public pageAdapter(FragmentManager fm) {
        super(fm);
    }
    MoviesFragment moviesFragment;
    TvShowsFragment tvShowsFragment;
    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            if(moviesFragment==null)
            {
                moviesFragment=new MoviesFragment();
            }
            return moviesFragment;
        }
        else
        {
            if(tvShowsFragment==null)
            {
                tvShowsFragment =new TvShowsFragment();
            }
            return tvShowsFragment;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }
}
