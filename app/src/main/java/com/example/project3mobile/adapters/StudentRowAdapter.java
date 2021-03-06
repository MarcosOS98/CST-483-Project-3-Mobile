package com.example.project3mobile.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project3mobile.R;
import com.example.project3mobile.databinding.StudentRowItemBinding;

public class StudentRowAdapter extends RecyclerView.Adapter<StudentRowAdapter.ViewHolder> {

    private StudentRowItemBinding binding;
    private Context context;

    // TODO: vvv DATA INITIALIZATION IN ARRAY/LIST WOULD GO HERE vvv

    /*List<Assignments> list;  <-- not sure if this is needed

    public StudentRowAdapter(List<> list, Context context){
        this.list = list;
        this.context = context;
    }*/

    @NonNull
    @Override
    public StudentRowAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_row_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentRowAdapter.ViewHolder holder, int position) {
        // TODO: vvv FILLING THE LIST WITH DATA WITH .GET'S GOES HERE vvv
        //holder.className.setText(list.get(position).getName());
        //holder.assignmentName.setText(list.get(position).getName());
        //holder.dueDate.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        // TODO: RETURN DATA ARRAY/LIST SIZE HERE
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView className;
        TextView assignmentName;
        TextView dueDate;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            className = binding.className;
            assignmentName = binding.assignName;
            dueDate = binding.dueDate;
            linearLayout = binding.layoutId;
        }
    }

}
