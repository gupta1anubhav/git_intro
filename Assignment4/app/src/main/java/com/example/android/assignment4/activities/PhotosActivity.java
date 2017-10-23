package com.example.android.assignment4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.assignment4.R;
import com.example.android.assignment4.adapters.PhotosAdapter;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
RecyclerView rvPhotos;
ProgressBar pbPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);
        rvPhotos= (RecyclerView) findViewById(R.id.rvPhotos);
        pbPhotos= (ProgressBar) findViewById(R.id.pbPhotos);
        pbPhotos.setIndeterminate(true);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));
        Bundle extras= getIntent().getExtras();
        int x=extras.getInt("photos");
        final PhotosAdapter photosAdapter= new PhotosAdapter(this);
        rvPhotos.setAdapter(photosAdapter);
        ApiService.getApi().getPhotosByAlbums(x).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photosAdapter.updatePhotos(response.body());
                pbPhotos.setIndeterminate(false);
                pbPhotos.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });
    }
}
