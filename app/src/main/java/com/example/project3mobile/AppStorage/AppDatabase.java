package com.example.project3mobile.AppStorage;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project3mobile.models.Assignment;
import com.example.project3mobile.models.Course;
import com.example.project3mobile.models.User;
@Database(entities = {User.class, Course.class, Assignment.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appInstance;
    public static synchronized AppDatabase getInstance(Context context) {
        if(appInstance == null) {
            appInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "")
                    .allowMainThreadQueries()
                    .build();
        }
        return appInstance;
    }
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COURSE_TABLE = "COURSE_TABLE";
    public static final String ASSIGNMENT_TABLE = "ASSIGNMENT_TABLE";

    public abstract UserDAO getUserDAO();
}