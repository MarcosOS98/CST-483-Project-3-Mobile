package com.example.project3mobile.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project3mobile.R;
import com.example.project3mobile.databinding.FragmentStudentHomeBinding;

public class StudentHomeFragment extends Fragment {

    private FragmentStudentHomeBinding binding;
    RecyclerView recyclerView;
    // <-- Data initialized here again?

    public StudentHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStudentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.recycler;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        super.onCreate(savedInstanceState);

        // TODO: INITIALIZE DATA

        return view;
    }
}