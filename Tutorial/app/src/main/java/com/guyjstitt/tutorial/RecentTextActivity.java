package com.guyjstitt.tutorial;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by gstitt on 11/25/14.
 */
public class RecentTextActivity extends FragmentActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_text);

        ListFragment frag = new ListFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.listContainer,frag,"Form Frag");
        transaction.commit();

    }

}
