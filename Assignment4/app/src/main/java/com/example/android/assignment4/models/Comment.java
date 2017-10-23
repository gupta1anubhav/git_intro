package com.example.android.assignment4.models;

import static android.R.attr.id;

/**
 * Created by Sushila on 9/13/2017.
 */

public class Comment {
    public Comment(String name, String email, String body) {
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }

    String name; String email; String body;

}
