package com.example.android.assignment4.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.android.assignment4.R;
import com.example.android.assignment4.models.Todo;

import java.util.ArrayList;

/**
 * Created by Sushila on 9/13/2017.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodoViewHolder> {
    public TodosAdapter(Context context) {
        this.context = context;
    }

    Context context;
    ArrayList<Todo> todos= new ArrayList<>();
    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView= li.inflate(R.layout.list_item_todo,parent,false);
        return new TodoViewHolder(itemView);
    }
    public  void updateTodos(ArrayList<Todo> todos){
        this.todos=todos;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
       holder.tvTodo.setText(todos.get(position).getTitle());
       holder.cbTodo.setChecked(todos.get(position).isCompleted());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTodo;
        CheckBox cbTodo;
        public TodoViewHolder(View itemView) {
            super(itemView);
            tvTodo= (TextView) itemView.findViewById(R.id.tvTodo);
            cbTodo= (CheckBox) itemView.findViewById(R.id.cbTodo);
        }
    }
}
