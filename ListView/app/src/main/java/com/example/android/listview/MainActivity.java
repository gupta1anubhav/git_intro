package com.example.android.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<Course> courseList= new ArrayList<>();
    ListView lvCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.list_card);
        generateCourses(courseList);
        lvCourses=(ListView)findViewById(R.id.ltv);
        CourseAdapter courseAdapter= new CourseAdapter(this,courseList);
        lvCourses.setAdapter(courseAdapter);
    }
    static void generateCourses (ArrayList<Course> courses) {
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 14));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 14));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
        courses.add(new Course("Pandora", "Pitampura", 22));
        courses.add(new Course("Elixir", "Pitampura", 22));
        courses.add(new Course("Launchpad", "Pitampura", 24));
        courses.add(new Course("Crux", "Pitampura", 24));
        courses.add(new Course("Algo++", "Pitampura", 14));
        courses.add(new Course("Perceptron", "Pitampura", 22));
        courses.add(new Course("Pandora", "Dwarka", 22));
        courses.add(new Course("Elixir", "Dwarka", 22));
        courses.add(new Course("Launchpad", "Dwarka", 24));
        courses.add(new Course("Crux", "Dwarka", 24));
    }
}
