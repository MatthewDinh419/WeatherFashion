package com.example.weatherfashion;

import java.util.ArrayList;

import org.json.JSONArray;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Geocode {
    public static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    public static final String API_KEY = "AIzaSyBJD5HRyjIM0fxM-lwzTDFvw9Z_LgfHjGY";

    private String city;
    private String state;
    private AsyncHttpClient client;

    ArrayList<Double> coord = new ArrayList<Double>();

    public Geocode(String new_city, String new_state) {
        city = new_city;
        state = new_state;
        client = new AsyncHttpClient();
    }

    public ArrayList<Double> getArray(){
        System.out.println("Lat: " + coord.get(0));
        System.out.println("Long: " + coord.get(1));
        return coord;
    }

    //GEOCODE API
    public ArrayList<Double> getCoordinates(final GeocodeResponse callback){

        coord.clear();

        client.get(BASE_URL + city + ",+" + state + "&key=" + API_KEY, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {

                    //Parse JSON data
                    String response = new String(responseBody);
                    JSONObject root = new JSONObject(response);
                    JSONArray jsonObject1 = (JSONArray) root.get("results");
                    JSONObject jsonObject2 = (JSONObject)jsonObject1.get(0);
                    JSONObject jsonObject3 = (JSONObject)jsonObject2.get("geometry");
                    JSONObject location = (JSONObject) jsonObject3.get("location");

                    //Add Coordinates to array
                    coord.add(location.getDouble("lat"));
                    coord.add(location.getDouble("lng"));

                    //Send information to caller
                    callback.onResponseReceived(coord);
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
        return coord;
    }
}
