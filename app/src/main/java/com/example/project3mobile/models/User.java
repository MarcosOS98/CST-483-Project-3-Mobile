package com.example.project3mobile.models;

import android.widget.EditText;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project3mobile.AppStorage.AppDatabase;

// Connects the .java file to the Database
@Entity(tableName = AppDatabase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int mUserId;

    @ColumnInfo(name = "username")
    private String mUserName;

    @ColumnInfo(name = "password")
    private String mPassword;

    @ColumnInfo(name = "first_name")
    private String mFirstName;

    @ColumnInfo(name = "last_name")
    private String mLastName;

    @ColumnInfo(name = "is_prof")
    private boolean mIsProf;

    public User(String mFirstName, String mLastName, String mUserName, String mPassword, boolean mIsProf) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mUserName = mUserName;
        this.mPassword = mPassword;
        this.mIsProf = mIsProf;
    }


    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public boolean isProf() {
        return mIsProf;
    }
    public void setProf(boolean mIsProf) {
        this.mIsProf = mIsProf;
    }

}