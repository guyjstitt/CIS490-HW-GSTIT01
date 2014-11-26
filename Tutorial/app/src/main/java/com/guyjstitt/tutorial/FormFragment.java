package com.guyjstitt.tutorial;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.parse.ParseObject;


public class FormFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        Button sendButton = (Button) view.findViewById(R.id.button);
        final EditText mText = (EditText) view.findViewById(R.id.editText);
        Button recentTextBtn = (Button) view.findViewById(R.id.recentTextBtn);

        sendButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view) {
                        String parseText = mText.getText().toString();
                        ParseObject textObject = new ParseObject("textObject");
                        textObject.put("parseText",parseText);
                        textObject.put("recent","true");
                        textObject.saveInBackground();
                    }
                }
        );

        recentTextBtn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(),RecentTextActivity.class);
                        startActivity(intent);
                    }
                }
        );


        return view;
    }


}
