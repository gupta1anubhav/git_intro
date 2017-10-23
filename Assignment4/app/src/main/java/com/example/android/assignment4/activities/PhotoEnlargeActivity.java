package com.example.android.assignment4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.android.assignment4.R;
import com.squareup.picasso.Picasso;

import static com.example.android.assignment4.R.id.imgPhoto;

public class PhotoEnlargeActivity extends AppCompatActivity {
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_enlarge);
        Bundle extras= getIntent().getExtras();
        img= (ImageView) findViewById(R.id.img);
        String url=extras.getString("hi");
        Picasso.with(this)
                .load(url)
                .into(img);
    }
}
