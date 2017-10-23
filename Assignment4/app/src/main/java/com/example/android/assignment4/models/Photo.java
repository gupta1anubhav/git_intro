package com.example.android.assignment4.models;

/**
 * Created by Sushila on 9/13/2017.
 */

public class Photo {
    public Photo(String url, String title) {
        this.url = url;
        this.title = title;
    }

    String url;
    String title;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }
}
