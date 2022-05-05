package com.example.project3mobile.api;

import com.example.project3mobile.models.Course;
import com.example.project3mobile.models.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/** An interface for Retrofit that holds all the API calls necessary for using the app
 * @author Andrew Liddle
 */

public interface ApiCalls {

    // User Calls
    /**
     * Call for creating a new user profile in the api database
     * @param fName users first name
     * @param lName users last name
     * @param username username chosen
     * @param password password chosen by user
     * @param isProf true = a professor with privileges
     * @return a confirmation string
     */
    @POST("/createUser")
    Call<String> createUser(
            @Field("firstname") String fName, @Field("lastname") String lName,
            @Field("username") String username, @Field("password") String password,
            @Field("isProf") boolean isProf);

    // TODO: Modify the User object or create a new one + converter for the result of User calls
    @GET("/getUser")
    Call<User> getUser(@Query("userId") Integer userId);

    // Course Calls
    @GET("/getAllCourses")
    Call<Iterable<Course>> getAllCourses();

    @POST("/addCourseToUser")
    Call<String> addCourseToUser(@Field("userId") Integer userId,
                                 @Field("courseId") Integer courseId);

    @POST("/createCourse")
    Call<String> createCourse(@Field("courseName") String courseName,
                              @Field("courseTime") String courseTime,
                              @Field("userId") Integer userId);

    @POST("/deleteCourse")
    Call<String> deleteCourse(@Field("courseId") Integer courseId);

    // Assignment Calls
    @POST("/createAssignment")
    Call<String> createAssignment(@Field("assignmentName") String assignmentName,
                                  @Field("courseId") Integer courseId,
                                  @Field("assignmentDescription") String assignmentDescription,
                                  @Field("dueDate") String dueDate);

    @POST("/deleteAssignment")
    Call<String> deleteAssignment(@Field("assignmentId") Integer assignmentId);

    // TODO: IMPLEMENT REMAINING API CALLS WHEN THEY ARE PROVIDED
}
