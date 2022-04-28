package com.example.project3mobile.fragments;

/** The fragment for a single class, listing all assignments due for only that class. Very similar
 * to StudentHome, but using a different data set for the recycler.
 * @author Andrew Liddle
 */

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project3mobile.R;
import com.example.project3mobile.adapters.StudentRowAdapter;
import com.example.project3mobile.databinding.FragmentClassBinding;
import com.example.project3mobile.databinding.FragmentStudentHomeBinding;

public class ClassFragment extends Fragment {

    private FragmentClassBinding binding;
    RecyclerView recyclerView;

    // TODO: ADD DISPLAY-ASSIGNMENT FUNCTIONALITY TO ITEMS OF RECYCLER

    public ClassFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentClassBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.recycler;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        super.onCreate(savedInstanceState);

        // TODO: vvv INITIALIZE DATA vvv
        //recyclerView.setAdapter(new StudentRowAdapter([PUT DATA LIST HERE],getContext()));

        return view;
    }
}