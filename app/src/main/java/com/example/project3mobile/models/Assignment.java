package com.example.project3mobile.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.project3mobile.AppStorage.AppDatabase;

@Entity(tableName = AppDatabase.ASSIGNMENT_TABLE)
public class Assignment {

    @PrimaryKey(autoGenerate = true)
    private Integer assignmentId;

    @ColumnInfo(name = "assignment_name")
    private String assignmentName;

    @ColumnInfo(name = "assignment_description")
    private String assignmentDescription;

    @ColumnInfo(name = "due_date")
    private String dueDate;

    @ColumnInfo(name = "is_complete")
    private Boolean isComplete;

    public Assignment() {

    }

    public Assignment(Integer assignmentId, String assignmentName, String assignmentDescription, String dueDate, Boolean isComplete) {
        this.assignmentId = assignmentId;
        this.assignmentName = assignmentName;
        this.assignmentDescription = assignmentDescription;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentDescription() {
        return assignmentDescription;
    }

    public void setAssignmentDescription(String assignmentDescription) {
        this.assignmentDescription = assignmentDescription;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getComplete() {
        return isComplete;
    }

    public void setComplete(Boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", assignmentName='" + assignmentName + '\'' +
                ", assignmentDescription='" + assignmentDescription + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }
}
