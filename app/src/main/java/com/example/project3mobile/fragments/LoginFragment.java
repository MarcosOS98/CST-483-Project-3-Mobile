package com.example.project3mobile.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
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
import com.example.project3mobile.api.ApiCalls;
import com.example.project3mobile.models.User;
import com.example.project3mobile.databinding.FragmentLoginBinding;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginFragment extends Fragment {
    private EditText mUsername;
    private EditText mPassword;

    private Button mLoginBtn;
    private Button mRegisterBtn;
    private UserDAO mUserDAO;

    private String mUserString;
    private String mPasswordString;
    private User mUser;
    AppDatabase appDB;
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        //appDB = AppDatabase.getInstance(this.getActivity());
        return binding.getRoot();
    }

    private Boolean LoginDisplay() {
        getActivity();
        mUsername = getView().findViewById(R.id.username);
        mPassword = getView().findViewById(R.id.password);
        mLoginBtn = getView().findViewById(R.id.loginButton);
        mRegisterBtn = getView().findViewById(R.id.registerButton);

        mUserString = mUsername.getText().toString();
        mPasswordString = mPassword.getText().toString();

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
        getDatabase();
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
    public static Intent intentFactory(Context context) {
        Intent intent = new Intent(context, LoginFragment.class);
        return intent;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_LoginFragment_to_RegisterFragment);
            }
        });

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (LoginDisplay()) {
                    NavHostFragment.findNavController(LoginFragment.this)
                            .navigate(R.id.action_LoginFragment_to_LandingFragment);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Retrieves the User data from the remote database via Retrofit2, with okhttp3 for debug and
     * logging
     */
    public void contactAPI(){
        String apiBaseString = ""; // TODO: This is where the base url from heroku will be
        ApiCalls api;

        // okhttp3 for debug and log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        // creating Retrofit object for calls. Includes debug.
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(apiBaseString)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(ApiCalls.class);

        // Async call for User
        Call<User> userCall = api.getUser(123456); // TODO: API call wth username & password
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("API","onResponse: User Successfully retrieved");
                User user = response.body();
                // TODO: Complete successful response code
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("FAIL","onFailure: Failed to get User");
                // TODO: Complete unsuccessful response code
            }
        });
        // TODO: Work out how to async return user data
    }
}