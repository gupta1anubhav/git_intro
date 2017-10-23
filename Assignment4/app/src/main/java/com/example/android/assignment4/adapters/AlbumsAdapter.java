package com.example.android.assignment4.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.assignment4.R;
import com.example.android.assignment4.activities.CommentsActivity;
import com.example.android.assignment4.activities.PhotosActivity;
import com.example.android.assignment4.models.Album;

import java.util.ArrayList;

/**
 * Created by Sushila on 9/13/2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {
    public AlbumsAdapter(Context context) {
        this.context = context;
    }

    ArrayList<Album> albums=new ArrayList<>();
    Context context;

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_album,parent,false);
        return new AlbumViewHolder(itemView);
    }
    public void updateAlbums(ArrayList<Album> albums){
        this.albums=albums;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(AlbumViewHolder holder, final int position) {
        holder.tvAlbumTitle.setText(albums.get(position).getTitle());
        holder.btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,PhotosActivity.class);
                intent.putExtra("photos",albums.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlbumTitle;
        Button btnAlbum;
        public AlbumViewHolder(View itemView) {
            super(itemView);
            tvAlbumTitle= (TextView) itemView.findViewById(R.id.tvAlbumTitle);
            btnAlbum= (Button) itemView.findViewById(R.id.btnAlbum);
        }

    }
}
