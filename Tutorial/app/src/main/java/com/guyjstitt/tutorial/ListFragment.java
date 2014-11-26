package com.guyjstitt.tutorial;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.guyjstitt.tutorial.adapter.ListViewAdapter;
import com.guyjstitt.tutorial.model.TextModel;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gstitt on 11/25/14.
 */
public class ListFragment extends Fragment {
    // Declare Variables
    ListView listview;
    List<ParseObject> ob;
    ListViewAdapter adapter;
    private List<TextModel> recentTextlist = null;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        new RemoteDataTask(view).execute();

        return view;
    }

    // RemoteDataTask AsyncTask
    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {

        private View mView;

        public RemoteDataTask(View view) {
            mView = view;
        }

        @Override
        protected Void doInBackground(Void... params) {

            // Create the array
            recentTextlist = new ArrayList<TextModel>();
            try {

                ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("textObject");
                query.whereEqualTo("recent", "true");
                ob = query.find();
                for (ParseObject trend: ob) {

                    TextModel rt = new TextModel();
                    rt.setText((String) trend.get("parseText"));
                    recentTextlist.add(rt);
                }

            } catch (ParseException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            System.out.println("HEYY " +recentTextlist);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Locate the listview in recent trend view
            listview = (ListView) mView.findViewById(R.id.listView);
            // Pass the results into ListViewAdapter.java
            adapter = new ListViewAdapter(mView.getContext(),
                    recentTextlist);
            // Binds the Adapter to the ListView
            listview.setAdapter(adapter);
        }
    }

}
