package com.example.android.assignment4.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sushila on 9/13/2017.
 */

public class ApiService {
    public static API api= null;
    public static API getApi(){
        if (api==null){
            Retrofit retrofit= new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create()).build();
            api= retrofit.create(API.class);
        }
        return api;
    }
}
