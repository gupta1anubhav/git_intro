package com.example.android.assignment4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.assignment4.R;
import com.example.android.assignment4.adapters.AlbumsAdapter;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AlbumsActivity extends AppCompatActivity {
RecyclerView rvAlbums;
ProgressBar pbAlbums;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        rvAlbums= (RecyclerView) findViewById(R.id.rvAlbums);
        pbAlbums= (ProgressBar) findViewById(R.id.pbAlbums);
        pbAlbums.setIndeterminate(true);
        rvAlbums.setLayoutManager(new LinearLayoutManager(this));
        final AlbumsAdapter albumsAdapter= new AlbumsAdapter(this);
        rvAlbums.setAdapter(albumsAdapter);
        ApiService.getApi().getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
               albumsAdapter.updateAlbums(response.body());
                pbAlbums.setIndeterminate(false);
                pbAlbums.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}
