package com.example.android.assignment4.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.assignment4.R;
import com.example.android.assignment4.adapters.TodosAdapter;
import com.example.android.assignment4.api.ApiService;
import com.example.android.assignment4.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosActivity extends AppCompatActivity {
RecyclerView rvTodos;
ProgressBar pbTodos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);
        rvTodos= (RecyclerView) findViewById(R.id.rvTodos);
        pbTodos= (ProgressBar) findViewById(R.id.pbTodos);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));
        pbTodos.setIndeterminate(true);
        final TodosAdapter todosAdapter= new TodosAdapter(this);
        rvTodos.setAdapter(todosAdapter);
        int x=0;
        if(getIntent().getExtras()!=null){
            Bundle extras=getIntent().getExtras();
            x= extras.getInt("todo");
        }
        if(x==0){
        ApiService.getApi().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
            @Override
            public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                todosAdapter.updateTodos(response.body());
                pbTodos.setIndeterminate(false);
                pbTodos.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

            }
        });}
        else{
            ApiService.getApi().getTodosOfUsers(x).enqueue(new Callback<ArrayList<Todo>>() {
                @Override
                public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                    todosAdapter.updateTodos(response.body());
                    pbTodos.setIndeterminate(false);
                    pbTodos.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

                }
            });
        }
    }
}
