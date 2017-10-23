package com.example.android.assignment4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.assignment4.R;
import com.example.android.assignment4.adapters.UsersAdapter;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersActivity extends AppCompatActivity {
    RecyclerView rvUsers;
    ProgressBar pbUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        rvUsers= (RecyclerView) findViewById(R.id.rvUsers);
        pbUsers= (ProgressBar) findViewById(R.id.pbUsers);
        pbUsers.setIndeterminate(true);
        rvUsers.setLayoutManager(new LinearLayoutManager(this));
        final UsersAdapter usersAdapter= new UsersAdapter(this);
        rvUsers.setAdapter(usersAdapter);
        ApiService.getApi().getUsers().enqueue(new Callback<ArrayList<User>>() {
            @Override
            public void onResponse(Call<ArrayList<User>> call, Response<ArrayList<User>> response) {
                usersAdapter.updateUsers(response.body());
                pbUsers.setIndeterminate(false);
                pbUsers.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<User>> call, Throwable t) {

            }
        });
    }
}
