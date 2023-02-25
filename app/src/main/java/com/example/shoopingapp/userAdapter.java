package com.example.shoopingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder> {
  Context context;
  ArrayList<itemModel>list;

    public userAdapter(Context context, ArrayList<itemModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item, parent,false);
        return new userViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
          itemModel user=list.get(position);
          holder.firstname.setText(user.getFirstName());
          holder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class userViewHolder extends RecyclerView.ViewHolder{
       TextView firstname;
       TextView email;
       public userViewHolder(@NonNull View itemView) {
           super(itemView);
           firstname=itemView.findViewById(R.id.textView);
           email=itemView.findViewById(R.id.email);
       }
   }
}
