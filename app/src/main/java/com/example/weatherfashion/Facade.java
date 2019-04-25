package com.example.weatherfashion;
import java.util.ArrayList;

public class Facade {
    static User new_user;
    static String temperature;
    static Double rtemperature;

    //Update Weather Information
    static public void UpdateWeather(){
        //Convert city and state to coordinates
        final Geocode geoguess = new Geocode(new_user.get_city(), new_user.get_state());
        final ArrayList<Double> test = geoguess.getCoordinates(new GeocodeResponse() {
            @Override
            public void onResponseReceived(ArrayList<Double> coord_response) {
                //Get Weather Information
                Darksky darksky = new Darksky(coord_response.get(0),coord_response.get(1));
                Weather new_weather = darksky.setWeather(new DarkskyResponse() {
                    @Override
                    public void onResponseReceived(Weather new_weather_pass) {
                        temperature = Double.toString(new_weather_pass.getTemperature());
                        rtemperature = Double.parseDouble(temperature);
                        HomePage.setText("Temperature: " + temperature, new_user.get_city(), new_user.get_state());
                    }
                });
            }
        });
    }

    //Updates Outfit Information
    static public void UpdateOutfits(){
        ArrayList<Clothing> clothing_to_wear = Clothing.GenerateOutfit(rtemperature, new_user);
        GeneralOutfit.setTextView(clothing_to_wear);
    }

    public Facade(){
    }
}
