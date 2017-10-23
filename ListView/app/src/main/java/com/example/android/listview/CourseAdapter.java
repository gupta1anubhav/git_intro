package com.example.android.listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sushila on 8/26/2017.
 */

public class CourseAdapter extends BaseAdapter {
    final static String TAG= "AL";
    Context context;
    ArrayList<Course> courses;
    public CourseAdapter(Context context, ArrayList<Course> courses) {
        this.context=context;
        this.courses=courses;
    }

    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG,"Hi");
        if(itemView==null) {
            itemView = li.inflate(R.layout.list_item_course, viewGroup, false);
        }
        else{}
        ((TextView) itemView.findViewById(R.id.tvCourseName)).setText(getItem(i).getName());
        ((TextView) itemView.findViewById(R.id.tvCenter)).setText(getItem(i).getCenter());
        ((TextView) itemView.findViewById(R.id.tvClasses)).setText(getItem(i).getClasses().toString());
        return  itemView;

    }
}
