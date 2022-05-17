package com.example.project3mobile.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.project3mobile.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project3mobile.AppStorage.AppDatabase;
import com.example.project3mobile.AppStorage.UserDAO;
import com.example.project3mobile.api.ApiCalls;
import com.example.project3mobile.models.User;
import com.example.project3mobile.databinding.FragmentRegisterBinding;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class RegisterFragment extends Fragment {
    private FragmentRegisterBinding binding;
    private EditText mFirstName;
    private EditText mLastName;
    private EditText mUsername;
    private EditText mPassword;
    private EditText mValidPass;

    private UserDAO mUserDAO;
    private User mUser;
    AppDatabase appDB;

    private String mFirstNameString;
    private String mLastNameString;
    private String mUsernameString;
    private String mPasswordString;
    private String mValidPassString;

    public RegisterFragment() {
        // Required empty public constructor
    }

    private boolean mIsProf;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkDatabase() && validatePasswords() && allFields() && checkBox()) {
                    User newUser = new User(mFirstNameString, mLastNameString, mUsernameString, mPasswordString, mIsProf);
                    mUserDAO.insert(newUser);
                    NavHostFragment.findNavController(RegisterFragment.this)
                            .navigate(R.id.action_to_RegisterFragment_to_LoginFragment);
                }
            }
        });
    }

    private boolean checkDatabase() {
        mUsername = getView().findViewById(R.id.username);
        mUsernameString =  mUsername.getText().toString();
        getDatabase();
        mUser = mUserDAO.getUserByUsername(mUsernameString);
        if (mUser != null) {
            Toast.makeText(getContext(), "Username already in use", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private boolean checkBox() {
        if(binding.checkBox.isChecked()) {
            mIsProf = true;
        } else {
            mIsProf = false;
        }
        return true;
    }

    private boolean validatePasswords() {
        mPassword = getView().findViewById(R.id.password);
        mValidPass = getView().findViewById(R.id.re_enter_password);
        mPasswordString = mPassword.getText().toString();
        mValidPassString = mValidPass.getText().toString();

        if (mPasswordString.equals(mValidPassString)) {
            return true;
        } else {
            Toast.makeText(getContext(), "Passwords must match", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    private boolean allFields() {
        mFirstName = getView().findViewById(R.id.firstName);
        mLastName = getView().findViewById(R.id.lastName);
        mUsername = getView().findViewById(R.id.username);
        mPassword = getView().findViewById(R.id.password);
        mValidPass = getView().findViewById(R.id.re_enter_password);

        mFirstNameString = mFirstName.getText().toString();
        mLastNameString = mLastName.getText().toString();
        mUsernameString = mUsername.getText().toString();
        mPasswordString = mPassword.getText().toString();
        mValidPassString = mValidPass.getText().toString();

        if(mFirstNameString.isEmpty()) {
            Toast.makeText(getContext(), "Error: First Name field can not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mLastNameString.isEmpty()) {
            Toast.makeText(getContext(), "Error: Last Name field can not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mUsernameString.isEmpty()) {
            Toast.makeText(getContext(), "Error: Username field can not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mPasswordString.isEmpty()) {
            Toast.makeText(getContext(), "Error: Password field can not be empty", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(mValidPassString.isEmpty()) {
            Toast.makeText(getContext(), "Error: Re-Enter Password field can not be empty", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /**
     * Registers a new User with the remote database via Retrofit2 call
     * @param fName user first name
     * @param lName user last name
     * @param username user's chosen username
     * @param password user's chosen password (pre-validated please)
     * @param isProf whether user is a professor or not
     */
    public void registerUser(String fName, String lName, String username, String password, boolean isProf){
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
        Call<String> userCall = api.createUser(fName, lName, username, password, isProf);
        userCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("API","onResponse: User Successfully registered");
                // TODO: Complete successful response code
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("FAIL","onFailure: Failed to register User");
                // TODO: Complete unsuccessful response code
            }
        });
    }
}