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
import com.example.android.assignment4.activities.PostsActivity;
import com.example.android.assignment4.models.Comment;

import java.util.ArrayList;

import static com.example.android.assignment4.R.id.tvCommentEmail;

/**
 * Created by Sushila on 9/13/2017.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    ArrayList<Comment> comments= new ArrayList<>();
    public CommentsAdapter(Context context) {
        this.context = context;
    }
    public void updateComments(ArrayList<Comment> comments){
        this.comments=comments;
        notifyDataSetChanged();
    }
    Context context;
    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=li.inflate(R.layout.list_item_comment,parent,false);
        return new CommentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
      holder.bindView(comments.get(position));

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder{
        TextView tvCommentEmail,tvCommentName,tvCommentBody;
        public CommentViewHolder(View itemView) {
            super(itemView);
            tvCommentBody= (TextView) itemView.findViewById(R.id.tvCommentBody);
            tvCommentEmail= (TextView) itemView.findViewById(R.id.tvCommentEmail);
            tvCommentName= (TextView) itemView.findViewById(R.id.tvCommentName);
        }
        public void bindView(final Comment comment){
            tvCommentEmail.setText(comment.getEmail());
            tvCommentBody.setText(comment.getBody());
            tvCommentName.setText(comment.getName());
        }

}
}
