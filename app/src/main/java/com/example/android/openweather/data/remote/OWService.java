package com.example.android.openweather.data.remote;

import com.example.android.openweather.data.model.City;
import com.example.android.openweather.data.model.Coord;
import com.example.android.openweather.data.model.OWResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by David on 07/02/2017.
 */

public interface OWService {
    @GET("daily?&mode=json&units=metric&cnt=14")
    Call<OWResponse> getResponse(@Query("q") String city, @Query("apiKey") String apiKey);



    @GET("users/{username}")
    Call<City> getUser(@Path("username") String username);



    @GET("group/{id}/users")
    Call<List<Coord>> groupList(@Path("id") int groupId, @Query("sort") String sort);



    @POST("users/new")
    Call<Coord> createUser(@Body Coord user);
}
