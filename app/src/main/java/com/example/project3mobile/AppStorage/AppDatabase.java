package com.example.project3mobile.AppStorage;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.project3mobile.User;
@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public static final String USER_TABLE = "USER_TABLE";

    public abstract UserDAO getUserDAO();
}