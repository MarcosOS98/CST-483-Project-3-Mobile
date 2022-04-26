package com.example.project3mobile.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.project3mobile.AppStorage.AppDatabase;
import com.example.project3mobile.AppStorage.UserDAO;
import com.example.project3mobile.R;
import com.example.project3mobile.User;
import com.example.project3mobile.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private EditText mUsername;
    private EditText mPassword;

    private Button mButton;
    private UserDAO mUserDAO;

    private String mUserString;
    private String mPasswordString;
    private User mUser;

    private FragmentLoginBinding binding;

    private Boolean LoginDisplay() {
        mUsername = mUsername.findViewById(R.id.username);
        mPassword = mPassword.findViewById(R.id.password);

        mUserString = (String) mUsername.getText().toString();
        mPasswordString = (String) mPassword.getText().toString();

        if(checkDatabase()) {
            if(!mUser.getPassword().equals(mPasswordString)) {
                Toast.makeText(getContext(), "Invalid Password", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean checkDatabase() {
        mUser = mUserDAO.getUserByUsername(mUserString);
        if(mUser == null) {
            Toast.makeText(getContext(), "No User Found", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private void getDatabase() {
        mUserDAO = Room.databaseBuilder(getContext(), AppDatabase.class, AppDatabase.USER_TABLE)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_registerFragment);
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_landingFragment);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}