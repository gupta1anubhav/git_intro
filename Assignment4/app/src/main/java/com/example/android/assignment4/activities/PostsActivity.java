package com.example.android.assignment4.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.android.assignment4.R;
import com.example.android.assignment4.adapters.PostsAdapter;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.x;

public class PostsActivity extends AppCompatActivity {
    public static final String TAG="hello";
RecyclerView rvPosts;
    ProgressBar pbPosts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        rvPosts= (RecyclerView) findViewById(R.id.rvPosts);
        pbPosts= (ProgressBar) findViewById(R.id.pbPosts);
        pbPosts.setIndeterminate(true);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));
        final PostsAdapter postsAdapter= new PostsAdapter(this);
        rvPosts.setAdapter(postsAdapter);
        int x=0;
        if(getIntent().getExtras()!=null){
            Bundle extras=getIntent().getExtras();
            x= extras.getInt("post");
        }
        Log.d(TAG, "onCreate: Size is "+x);
        if(x==0){
        ApiService.getApi().getPosts().enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                postsAdapter.updatePosts(response.body());
                pbPosts.setIndeterminate(false);
                pbPosts.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                //Toast.makeText(this,"HI",Toast.LENGTH_SHORT).show();
            }
        });}
        else {
           ApiService.getApi().getPostsOfUsers(x).enqueue(new Callback<ArrayList<Post>>() {
               @Override
               public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                   Log.d(TAG, "onResponse: "+response.body().size());
                   postsAdapter.updatePosts(response.body());
                   pbPosts.setIndeterminate(false);
                   pbPosts.setVisibility(View.INVISIBLE);
               }

               @Override
               public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

               }
           });
        }
    }
}
