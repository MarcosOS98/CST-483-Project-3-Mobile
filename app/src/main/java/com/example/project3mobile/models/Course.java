package com.example.project3mobile.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project3mobile.AppStorage.AppDatabase;

import java.util.List;

@Entity(tableName = AppDatabase.COURSE_TABLE)
public class Course {

    @PrimaryKey(autoGenerate = true)
    private Integer courseId;

    @ColumnInfo(name = "course_name")
    private String courseName;

    @ColumnInfo(name = "course_time")
    private String courseTime;

    @ColumnInfo(name = "professor")
    private String professor;

    //private List<Assignment> assignments;

    public Course() {

    }

    public Course(Integer classId, String className, String classTime, String professor) {
        this.courseId = classId;
        this.courseName = className;
        this.courseTime = classTime;
        this.professor = professor;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer classId) {
        this.courseId = classId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String className) {
        this.courseName = className;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String classTime) {
        this.courseTime = classTime;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    //public List<Assignment> getAssignments() {
        //return assignments;
    //}

//public void setAssignments(List<Assignment> assignments) {
        //this.assignments = assignments;
    //}

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseTime='" + courseTime + '\'' +
                ", professor='" + professor + '\'' +
                //", assignments=" + assignments +
                '}';
    }
}
