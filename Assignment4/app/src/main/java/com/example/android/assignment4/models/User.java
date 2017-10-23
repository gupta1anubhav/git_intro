package com.example.android.assignment4.models;

import static android.R.attr.id;

/**
 * Created by Sushila on 9/13/2017.
 */

public class User {
    int id;
    String name, username, email;
    Address address;

    public User(int id, String name, String username, String email, Address address) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    public Address getAddress(){
        return address;
    }
}
