package com.example.project3mobile.AppStorage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project3mobile.models.Assignment;
import java.util.List;

@Dao
public interface AssignmentDAO {
    @Insert
    void insert(Assignment... assignments);

    @Update
    void update(Assignment... assignments);

    @Delete
    void delete(Assignment assignments);

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE)
    List<Assignment> getAssignments();

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE + " WHERE assignmentId = :assignmentID")
    Assignment getAssignmentsByID(int assignmentID);

    @Query("SELECT * FROM " + AppDatabase.ASSIGNMENT_TABLE + " WHERE assignment_name = :assignmentName")
    Assignment getAssignmentByName(String assignmentName);
    
}
