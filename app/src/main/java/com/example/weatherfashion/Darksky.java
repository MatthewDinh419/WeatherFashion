package com.example.weatherfashion;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class Darksky {
    public static final String BASE_URL = "https://api.forecast.io/forecast/";
    public static final String API_KEY = "c09ec378f45e40e8cd22ec58e3c7f55e";

    private double latitude;
    private double longitude;
    private Weather new_weather;
    private AsyncHttpClient client;

    public Darksky(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        client = new AsyncHttpClient();
    }

    public void setWeather(){

        client.get(BASE_URL + API_KEY + "/" + latitude + "," + longitude, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {

                    //Parse JSON data
                    String response = new String(responseBody);
                    JSONObject root = new JSONObject(response);
                    JSONObject current = root.getJSONObject("currently");

                    //Create new weather object
                    new_weather = new Weather(current.getDouble("temperature"));
                }
                catch(Exception e) {
                    // TODO: handle
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("Failure for GET request");
            }
        });
    }
}
