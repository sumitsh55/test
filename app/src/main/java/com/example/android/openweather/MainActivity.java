package com.example.android.openweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.android.openweather.data.remote.ApiUtils;
import com.example.android.openweather.data.remote.OWService;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final OWService owService = ApiUtils.getOWService();
        interpretResponse(owService);
    }

    private void interpretResponse(OWService owService) {
        owService.getResponse("Vancouver", BuildConfig.OPEN_WEATHER_MAP_API_KEY).enqueue(new RetrofitCallback());
        owService.createUser("",new )
    }
}
