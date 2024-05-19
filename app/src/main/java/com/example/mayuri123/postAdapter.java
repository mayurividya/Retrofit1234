package com.example.mayuri123;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class postAdapter  extends RecyclerView.Adapter<postViewHolder> {
    public postAdapter(List<postAdapter> postAdapterList) {
        this.postAdapterList = postAdapterList;
    }

    private List<postAdapter> postAdapterList;


    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new postViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {
        postAdapter postAdapter = postAdapterList.get(position);
        holder.Title.setText(postAdapter.toString());
        holder.Body.setTag(postAdapter.toString());

    }

    @Override
    public int getItemCount() {

        return postAdapterList.size();
    }

}
