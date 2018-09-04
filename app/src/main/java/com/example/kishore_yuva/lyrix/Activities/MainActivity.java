package com.example.kishore_yuva.lyrix.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.kishore_yuva.lyrix.R;
import com.example.kishore_yuva.lyrix.Utilities;
import com.example.kishore_yuva.lyrix.Adapters.MusicPagerAdapter;
import com.google.android.gms.ads.AdView;



public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabs;
    private MusicPagerAdapter pagerAdapter;
    private Activity activity = this;
    private LyricsFragment lyricsFragment;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        boolean isTab = Utilities.isTablet(this);

        viewPager = (ViewPager) findViewById(R.id.pager);
        tabs = (TabLayout) findViewById(R.id.tabs);
        pagerAdapter = new MusicPagerAdapter(getSupportFragmentManager(), this, isTab);
        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);

        if(!isTab) {
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start search activity
                    Intent search = new Intent(activity, SearchActivity.class);
                    activity.startActivity(search);
                }
            });
        } else {
            lyricsFragment = (LyricsFragment) getSupportFragmentManager().findFragmentById(R.id.lyrics_frag);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    // Only relevant in tablets
    public void setSong(String title, String artist, String image) {
        lyricsFragment.setSong(title, artist, image);
    }

}
