package com.example.project3mobile.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;
import retrofit2.http.Query;

/** An interface for Retrofit that holds all the API calls necessary for using the app
 * @author Andrew Liddle
 */

public interface ApiCalls {

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

    // TODO: IMPLEMENT REMAINING API CALLS WHEN THEY ARE PROVIDED
}
