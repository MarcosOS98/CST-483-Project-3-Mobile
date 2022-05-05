package com.example.project3mobile.AppStorage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project3mobile.models.User;

import java.util.List;

@Dao
public interface UserDAO {
    // Standard edits for Accounts: Insert/Update/Delete
    @Insert
    void insert(User... users);

    @Update
    void update(User... users);

    @Delete
    void delete(User users);

    //Sorts All Users
    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    List<User> getUsers();

    // Sorts Users by Id
    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE mUserId = :UserID")
    User getUsersByID(int UserID);

    //Sorts Users by Username
    @Query("SELECT * FROM " + AppDatabase.USER_TABLE + " WHERE username = :username")
    User getUserByUsername(String username);
}
