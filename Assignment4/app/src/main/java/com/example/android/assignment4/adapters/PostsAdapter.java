package com.example.android.assignment4.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.assignment4.R;
import com.example.android.assignment4.activities.CommentsActivity;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Comment;
import com.example.android.assignment4.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.start;
import static android.R.attr.theme;
import static com.example.android.assignment4.R.id.btnPostComment;
import static com.example.android.assignment4.R.id.btnPostComment;
import static com.example.android.assignment4.R.id.tvPostBody;
import static com.example.android.assignment4.R.id.tvPostTitle;

/**
 * Created by Sushila on 9/13/2017.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    ArrayList<Post> posts= new ArrayList<>();
    Context context;
    public PostsAdapter(Context context) {
        this.context = context;
    }
    public void updatePosts(ArrayList<Post> posts){
        this.posts=posts;
        notifyDataSetChanged();
    }
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_post,parent,false);
        return new PostViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, int position) {
        holder.tvPostTitle.setText(posts.get(position).getTitle());
        holder.tvPostBody.setText(posts.get(position).getBody());
        holder.btnPostComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,CommentsActivity.class);
                intent.putExtra("ii",holder.getAdapterPosition());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
    TextView tvPostTitle,tvPostBody;
    Button btnPostComment;
        public PostViewHolder(View itemView) {
            super(itemView);
            tvPostBody= (TextView) itemView.findViewById(R.id.tvPostBody);
            tvPostTitle= (TextView) itemView.findViewById(R.id.tvPostTitle);
            btnPostComment= (Button) itemView.findViewById(R.id.btnPostComment);
        }
    }
}