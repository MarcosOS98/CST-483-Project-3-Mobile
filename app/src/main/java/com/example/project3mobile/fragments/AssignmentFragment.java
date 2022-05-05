package com.example.project3mobile.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.project3mobile.AppStorage.AppDatabase;
import com.example.project3mobile.AppStorage.UserDAO;
import com.example.project3mobile.R;
import com.example.project3mobile.User;
import com.example.project3mobile.databinding.FragmentAssignmentBinding;

public class AssignmentFragment extends Fragment {
    private TextView assign;
    private TextView assignDesc;
    private TextView assignDate;
    private TextView assignClass;

    private FragmentAssignmentBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAssignmentBinding.inflate(inflater, container, false);
        //appDB = AppDatabase.getInstance(this.getActivity());
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assign = assign.findViewById(R.id.assign);
        assignDesc = assignDesc.findViewById(R.id.assignDesc);
        assignDate = assignDate.findViewById(R.id.assignDate);
        assignClass = assignClass.findViewById(R.id.assignClass);

        assign.setText("Put Name of Assignment api call here");
        assignDesc.setText("Put Assignment Description api call here");
        assignDate.setText("Put Assignment Date api call here");
        assignClass.setText("Put Assignment Class api call here");


    }
}
