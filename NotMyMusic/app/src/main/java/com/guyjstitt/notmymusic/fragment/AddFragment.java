package com.guyjstitt.notmymusic.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guyjstitt.notmymusic.R;

/**
 * Created by gstitt on 10/31/14.
 */
public class AddFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_add,container,false);
        return view;
    }
}
