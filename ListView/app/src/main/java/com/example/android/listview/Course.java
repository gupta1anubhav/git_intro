package com.example.android.listview;

/**
 * Created by Sushila on 8/26/2017.
 */

public class Course {
    String name;
    String center;
    Integer classes;
    public String getName() {
        return name;
    }

    public String getCenter() {
        return center;
    }

    public Integer getClasses() {
        return classes;
    }



    public Course(String name, String center, int classes) {
        this.name = name;
        this.center = center;
        this.classes = classes;
    }
}
