package com.example.mayuri123;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class postViewHolder extends RecyclerView.ViewHolder {

    TextView Title,Body;

    public postViewHolder(@NonNull View itemView) {
        super(itemView);
        Title=itemView.findViewById(R.id.textViewTitle);
        Body=itemView.findViewById(R.id.textviewBody);
    }
}
