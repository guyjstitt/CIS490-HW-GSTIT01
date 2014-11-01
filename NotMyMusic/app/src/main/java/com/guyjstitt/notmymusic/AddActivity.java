package com.guyjstitt.notmymusic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.guyjstitt.notmymusic.fragment.AddFragment;

/**
 * Created by gstitt on 10/31/14.
 */
public class AddActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        AddFragment frag = new AddFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.addContainer,frag,"GuyFragment");
        transaction.commit();
    }
}
