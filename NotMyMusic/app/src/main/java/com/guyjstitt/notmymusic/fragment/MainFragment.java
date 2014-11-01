package com.guyjstitt.notmymusic.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.guyjstitt.notmymusic.R;
import com.guyjstitt.notmymusic.SongAdapter;
import com.guyjstitt.notmymusic.SongDetailActivity;

/**
 * Created by gstitt on 10/31/14.
 */
public class MainFragment extends Fragment {
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridView);
        gridView.setAdapter(new SongAdapter(getActivity()));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), SongDetailActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
