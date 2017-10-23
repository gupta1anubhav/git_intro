package com.example.android.assignment4.models;

/**
 * Created by Sushila on 9/13/2017.
 */

public class Address {
    String city, zipcode;

    public Address(String city, String zipcode) {
        this.city = city;
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }
}
