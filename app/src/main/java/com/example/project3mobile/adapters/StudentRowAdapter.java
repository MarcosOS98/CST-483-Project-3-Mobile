package com.example.project3mobile.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentRowAdapter extends RecyclerView.Adapter<StudentRowAdapter.Viewholder> {
    @NonNull
    @Override
    public StudentRowAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRowAdapter.Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
