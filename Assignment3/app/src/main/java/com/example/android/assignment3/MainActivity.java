package com.example.android.assignment3;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.android.assignment3.R.id.ll;

public class MainActivity extends AppCompatActivity {
RecyclerView rvCourses;
ImageButton btnAdd;
    EditText etCourse,etTeacher,etClasses;
ArrayList<Course> courses= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAdd= (ImageButton) findViewById(R.id.btnAdd);

        etCourse= (EditText) findViewById(R.id.etCourse);
        etTeacher= (EditText) findViewById(R.id.etTeacher);
        etClasses= (EditText) findViewById(R.id.etClasses);
        rvCourses= (RecyclerView) findViewById(R.id.rvCourses);
        courses= Course.generateCourses();
        final RecyclerCourseAdapter courseAdapter= new RecyclerCourseAdapter(this,courses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(courseAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((etCourse.getText().toString()).matches("")||(etTeacher.getText().toString()).matches("")||(etClasses.getText().toString()).matches(""))
                    Toast.makeText(MainActivity.this, "Enter Full Details", Toast.LENGTH_SHORT).show();
                else{Course e=new Course((etCourse.getText()).toString(),(etTeacher.getText()).toString(),
                        Integer.parseInt(etClasses.getText().toString()));
                courses.add(0,e);
                courseAdapter.notifyDataSetChanged();
                    rvCourses.smoothScrollToPosition(0);
            }}
        });
    }

}
