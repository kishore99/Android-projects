package com.example.kishore_yuva.lyrix.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.kishore_yuva.lyrix.Activities.FeedFragment;
import com.example.kishore_yuva.lyrix.Activities.SearchFragment;



public class MusicPagerAdapter extends FragmentPagerAdapter {
    private Context c;
    private String[] tabTitles = {"Popular","Recents","Favourites"};
    private String[] tabTitlesT = {"Popular", "Recents", "Favourites", "Search"};
    private boolean isTab;

    public MusicPagerAdapter(FragmentManager fm, Context c, boolean isTab) {
        super(fm);
        this.c = c;
        this.isTab = isTab;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 3) {
            return new SearchFragment();
        } else {
            FeedFragment f = new FeedFragment();
            f.setType(position);
            return f;
        }
    }
    @Override
    public int getCount() {
        return isTab ? tabTitlesT.length : tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return isTab ? tabTitlesT[position] : tabTitles[position];
    }
}
