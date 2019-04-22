package com.example.weatherfashion;
import java.util.ArrayList;

public class Facade {

    public Facade(String city, String state){

        //Convert city and state to coordinates
        final Geocode geoguess = new Geocode(city, state);
        final ArrayList<Double> test = geoguess.getCoordinates(new GeocodeResponse() {
            @Override
            public void onResponseReceived(ArrayList<Double> coord_response) {
                //MainActivity.setText(Double.toString(coord_response.get(0)));
                Darksky darksky = new Darksky(coord_response.get(0),coord_response.get(1));
                Weather new_weather = darksky.setWeather(new DarkskyResponse() {
                    @Override
                    public void onResponseReceived(Weather new_weather_pass) {
                        HomePage.setText("Temperature: " + Double.toString(new_weather_pass.getTemperature()));
                    }
                });
            }
        });
    }
}
