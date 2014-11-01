package com.guyjstitt.notmymusic.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.guyjstitt.notmymusic.R;

/**
 * Created by gstitt on 10/31/14.
 */
public class SongDetailFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_song_detail, container, false);
        return view;
    }
}