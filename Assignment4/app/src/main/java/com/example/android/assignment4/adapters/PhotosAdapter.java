package com.example.android.assignment4.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.assignment4.R;
import com.example.android.assignment4.activities.PhotoEnlargeActivity;
import com.example.android.assignment4.models.Photo;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static android.R.attr.width;

/**
 * Created by Sushila on 9/13/2017.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {
    Context context;
    ArrayList<Photo> photos=new ArrayList<>();

    public PhotosAdapter(Context context) {
        this.context = context;
    }
    public void updatePhotos(ArrayList<Photo> photos){
        this.photos=photos;
        notifyDataSetChanged();
    }
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView= li.inflate(R.layout.list_item_photo,parent,false);
        return new PhotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, final int position) {
      holder.tvPhotoTitle.setText(photos.get(position).getTitle());
        Picasso.with(context)
                .load(photos.get(position).getUrl())
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, PhotoEnlargeActivity.class);
                intent.putExtra("hi",photos.get(position).getUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvPhotoTitle;
        public PhotoViewHolder(View itemView) {
            super(itemView);
            imgPhoto= (ImageView) itemView.findViewById(R.id.imgPhoto);
            tvPhotoTitle= (TextView) itemView.findViewById(R.id.tvPhotoTitle);
        }
    }
}
