package com.example.android.assignment4.models;

/**
 * Created by Sushila on 9/13/2017.
 */

public class Album {
    public Album(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    int id;
    String title;

}
