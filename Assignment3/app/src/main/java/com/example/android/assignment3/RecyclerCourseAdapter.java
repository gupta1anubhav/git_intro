package com.example.android.assignment3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.android.assignment3.R.id.etClasses;
import static com.example.android.assignment3.R.id.etCourse;
import static com.example.android.assignment3.R.id.etTeacher;

/**
 * Created by Sushila on 8/31/2017.
 */

public class RecyclerCourseAdapter extends RecyclerView.Adapter<RecyclerCourseAdapter.MyHolder> {
    Context context;
    ArrayList<Course> courses;


    public RecyclerCourseAdapter(Context context, ArrayList<Course> courses) {
        this.context = context;
        this.courses = courses;

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course,parent,false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        holder.tvTeacher.setText(courses.get(position).getTeachername());
        holder.tvClasses.setText(courses.get(position).getClasses().toString());
        holder.tvName.setText(courses.get(position).getCoursename());
       holder.ibtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               courses.remove(holder.getAdapterPosition());
               notifyDataSetChanged();
           }
       });


    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvClasses,tvTeacher;
        ImageButton ibtn;
        public MyHolder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tvName);
            tvClasses= (TextView) itemView.findViewById(R.id.tvClasses);
            tvTeacher= (TextView) itemView.findViewById(R.id.tvTeacher);
            ibtn= (ImageButton) itemView.findViewById(R.id.ibtn);
        }
    }
}
