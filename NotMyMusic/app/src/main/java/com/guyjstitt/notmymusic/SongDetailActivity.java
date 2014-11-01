package com.guyjstitt.notmymusic;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.guyjstitt.notmymusic.fragment.SongDetailFragment;
import com.guyjstitt.notmymusic.listener.MyTabListener;

/**
 * Created by gstitt on 10/31/14.
 */
public class SongDetailActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab1 = actionbar.newTab().setText("Details");
        tab1.setTabListener(new MyTabListener());
        actionbar.addTab(tab1);

        ActionBar.Tab tab2 = actionbar.newTab().setText("More Music");
        tab2.setTabListener(new MyTabListener());
        actionbar.addTab(tab2);

        ActionBar.Tab tab3 = actionbar.newTab().setText("Events");
        tab3.setTabListener(new MyTabListener());
        actionbar.addTab(tab3);

        SongDetailFragment frag = new SongDetailFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.songDetail,frag,"SongDetailFragment");
        transaction.commit();


    }
}
