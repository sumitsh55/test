package com.example.android.openweather;

import android.util.Log;

import com.example.android.openweather.data.model.List;
import com.example.android.openweather.data.model.OWResponse;
import com.example.android.openweather.data.model.Temp;
import com.example.android.openweather.data.model.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by David on 07/02/2017.
 */

final class RetrofitCallback implements Callback<OWResponse> {

    private static final String LOG_TAG = RetrofitCallback.class.getSimpleName();

    @Override
    public void onResponse(Call<OWResponse> call, Response<OWResponse> response) {

        if (response.isSuccessful()) {
            Log.d(LOG_TAG, "onResponse successful");
            final OWResponse body = response.body();
            final String city = body.getCity().getName();
            Log.d(LOG_TAG, "city: " + city);
            // TODO: Rename List to WeatherData
            final java.util.List<List> weatherDataList = body.getList();
            for (List weatherData : weatherDataList) {
                printWeatherData(weatherData);
            }
        } else {
            Log.d(LOG_TAG, "onResponse unsuccessful");
        }
    }

    private void printWeatherData(List weatherData) {
        final Temp temp = weatherData.getTemp();
        final Double max = temp.getMax();
        final Double min = temp.getMin();
        // TODO: Rename Weather to WeatherDetails
        final java.util.List<Weather> weather = weatherData.getWeather();
        final Weather weatherDetails = weather.get(0);
        final String description = weatherDetails.getDescription();

        Log.d(LOG_TAG, "description: " + description);
        Log.d(LOG_TAG, "max: " + max);
        Log.d(LOG_TAG, "min: " + min);
    }

    @Override
    public void onFailure(Call<OWResponse> call, Throwable t) {
        Log.d(LOG_TAG, "onFailure");
    }
}
