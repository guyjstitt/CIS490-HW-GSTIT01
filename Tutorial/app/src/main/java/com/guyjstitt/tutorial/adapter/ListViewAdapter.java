package com.guyjstitt.tutorial.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.guyjstitt.tutorial.R;
import com.guyjstitt.tutorial.model.TextModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gstitt on 11/25/14.
 */
public class ListViewAdapter extends BaseAdapter{
    // Declare Variables
    Context context;
    LayoutInflater inflater;
    private List<TextModel> recentTextList = null;
    private ArrayList<TextModel> arraylist;

    public ListViewAdapter(Context context,
                           List<TextModel> recentTextList) {
        this.context = context;
        this.recentTextList = recentTextList;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<TextModel>();
        this.arraylist.addAll(recentTextList);
    }

    public class ViewHolder {
        TextView recentText;
    }

    @Override
    public int getCount() {
        return recentTextList.size();
    }

    @Override
    public Object getItem(int position) {
        return recentTextList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.view_for_recent_text, null);
            holder.recentText= (TextView) view.findViewById(R.id.textLabel);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.recentText.setText(recentTextList.get(position).getText());
        return view;
    }
}
