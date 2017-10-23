package com.example.android.assignment4.models;

/**
 * Created by Sushila on 9/13/2017.
 */

public class Todo {
    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    String title;
    boolean completed;

}
