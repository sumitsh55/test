package com.example.android.openweather.data.remote;

/**
 * Created by David on 07/02/2017.
 */

public class ApiUtils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast/";
    // "http://api.openweathermap.org/data/2.5/forecast/daily?q=Vancouver&mode=json&units=metric&cnt=14&APPID=693515b8b1b2ebef26f1046cc071be10"

    public static OWService getOWService() {
        return RetrofitClient
                .getClient(BASE_URL)
                .create(OWService.class);
    }
}
