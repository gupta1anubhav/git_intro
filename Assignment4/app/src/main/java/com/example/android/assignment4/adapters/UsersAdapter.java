package com.example.android.assignment4.adapters;

import android.app.Activity;
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
import com.example.android.assignment4.activities.PostsActivity;
import com.example.android.assignment4.activities.TodosActivity;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Post;
import com.example.android.assignment4.models.Todo;
import com.example.android.assignment4.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.android.assignment4.activities.CommentsActivity.TAG;

/**
 * Created by Sushila on 9/13/2017.
 */

public class UsersAdapter extends RecyclerView.Adapter <UsersAdapter.UserViewHolder>{
    Context context;
    ArrayList<User> users= new ArrayList<>();

    public UsersAdapter(Context context) {
        this.context = context;
    }
    public void updateUsers(ArrayList<User> users){
        this.users=users;
        notifyDataSetChanged();
    }
    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView= li.inflate(R.layout.list_item_user,parent,false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        holder.bindView(users.get(position));
        holder.btnPosts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(context,PostsActivity.class);
                Log.d(TAG, "onClick: "+users.get(position).getId());
                intent.putExtra("post",users.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.btnTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TodosActivity.class);
                intent.putExtra("todo",users.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName,tvUserUsername,tvUserEmail,tvUserAddressCity,tvUserAddressZipcode;
        Button btnTodos,btnPosts;
        public UserViewHolder(View itemView) {
            super(itemView);
            tvUserAddressCity= (TextView) itemView.findViewById(R.id.tvUserAddressCity);
            tvUserAddressZipcode= (TextView) itemView.findViewById(R.id.tvUserAddressZipcode);
            tvUserEmail= (TextView) itemView.findViewById(R.id.tvUserEmail);
            tvUserName= (TextView) itemView.findViewById(R.id.tvUserName);
            tvUserUsername= (TextView) itemView.findViewById(R.id.tvUserUsername);
            btnPosts= (Button) itemView.findViewById(R.id.btnPosts);
            btnTodos= (Button) itemView.findViewById(R.id.btnTodos);
        }
        public void bindView(User user){
            tvUserEmail.setText(user.getEmail());
            tvUserName.setText(user.getName());
            tvUserUsername.setText(user.getUsername());
            tvUserAddressCity.setText(user.getAddress().getCity());
            tvUserAddressZipcode.setText(user.getAddress().getZipcode());
        }
    }
}
