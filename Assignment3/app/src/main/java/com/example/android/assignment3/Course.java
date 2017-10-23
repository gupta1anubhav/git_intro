package com.example.android.assignment3;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Sushila on 8/30/2017.
 */

public class Course {
    String coursename;
    String teachername;
    int classes;
    public Course(String coursename, String teachername, int classes) {
        this.coursename = coursename;
        this.teachername = teachername;
        this.classes = classes;
    }



    public String getCoursename() {
        return coursename;
    }

    public String getTeachername() {
        return teachername;
    }

    public Integer getClasses() {
        return classes;
    }
    private static String[] courseNames = {
            "Pandora", "Crux", "Launchpad", "Elixir", "Algo++"
    };
    private static String[] teachers = {
            "Arnav", "Prateek", "Sumeet", "Rishabh", "Deepak", "Garima"
    };
    static ArrayList<Course> generateCourses(){
      ArrayList<Course> course= new ArrayList<>();
        Random r= new Random();
        for (int i=0 ; i <20 ;i++){
            Course obj= new Course(courseNames[r.nextInt(courseNames.length)],teachers[r.nextInt(teachers.length)],20+r.nextInt(5));
            course.add(obj);
        }
        return course;
    }
}
