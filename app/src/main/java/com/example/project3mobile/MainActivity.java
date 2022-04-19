package com.example.project3mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project3mobile.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(binding.getRoot());

        loginBtn = view.findViewById(R.id.loginBtn);
    }

    //put the name of the fragment/class you would like to load where LoginFragment.class
    //and change name of the class name to whatever the button is named instead of login
    public void login(View v){
        Intent intent = new Intent(getApplicationContext(), LoginFragment.class);
        startActivity(intent);
    }

}