package com.example.android.assignment4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.assignment4.R;
import com.example.android.assignment4.adapters.CommentsAdapter;
import com.example.android.assignment4.adapters.PostsAdapter;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.x;
import static com.example.android.assignment4.R.id.rvComments;

public class CommentsActivity extends AppCompatActivity {
    public static final String TAG="HEllo";
RecyclerView rvComments; ProgressBar pbComments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        rvComments= (RecyclerView) findViewById(R.id.rvComments);
        pbComments= (ProgressBar) findViewById(R.id.pbComments);
        pbComments.setIndeterminate(true);
        final CommentsAdapter commentsAdapter= new CommentsAdapter(this);
        rvComments.setLayoutManager(new LinearLayoutManager(this));
        rvComments.setAdapter(commentsAdapter);
        Bundle extras= getIntent().getExtras();
        Log.d(TAG, "onCreate: Got extras");
        Integer x= extras.getInt("ii");
        x++;
        Log.d(TAG, "onCreate: "+x.toString());
        ApiService.getApi().getCommentsByPosts(x).enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                Log.d(TAG, "onResponse: ");
                commentsAdapter.updateComments(response.body());
                pbComments.setIndeterminate(false);
                pbComments.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });
    }
}
