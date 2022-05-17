package com.example.project3mobile.AppStorage;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project3mobile.models.Course;
import java.util.List;

@Dao
public interface CourseDAO {
    @Insert
    void insert(Course... courses);

    @Update
    void update(Course... courses);

    @Delete
    void delete(Course courses);

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE)
    List<Course> getCourses();

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE courseId = :courseID")
    Course getCoursesByID(int courseID);

    @Query("SELECT * FROM " + AppDatabase.COURSE_TABLE + " WHERE course_name = :courseName")
    Course getCourseByName(String courseName);
    
}
