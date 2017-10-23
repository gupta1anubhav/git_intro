package com.example.android.assignment4;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.assignment4.activities.AlbumsActivity;
import com.example.android.assignment4.activities.PostsActivity;
import com.example.android.assignment4.activities.TodosActivity;
import com.example.android.assignment4.activities.UsersActivity;

import static android.R.attr.src;
import static com.example.android.assignment4.R.id.btn1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn1).setBackgroundResource(R.drawable.ic_assignment_black_24dp);
        findViewById(R.id.btn2).setBackgroundResource(R.drawable.ic_photo_album_black_24dp);
        findViewById(R.id.btn3).setBackgroundResource(R.drawable.ic_list_black_24dp);
        findViewById(R.id.btn4).setBackgroundResource(R.drawable.ic_group_black_24dp);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        findViewById(R.id.btn3).setOnClickListener(this);
        findViewById(R.id.btn4).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn1:{
                startActivity(new Intent(MainActivity.this,PostsActivity.class));
                break;
            }
            case R.id.btn2:{
                startActivity(new Intent(this,AlbumsActivity.class));
                break;
            }
            case R.id.btn3:{
                startActivity(new Intent(this,TodosActivity.class));
                break;
            }
            case R.id.btn4:{
                startActivity(new Intent(this,UsersActivity.class));
                break;
            }
        }
    }
}
