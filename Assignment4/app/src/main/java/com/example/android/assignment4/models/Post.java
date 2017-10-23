package com.example.android.assignment4.models;

/**
 * Created by Sushila on 9/13/2017.
 */

public class Post {
    int id;
    String title;
    String body;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Post(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
