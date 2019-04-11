package com.example.weatherfashion;

import java.util.ArrayList;

public interface GeocodeResponse{
    public void onResponseReceived(ArrayList<Double> coord_response);
}
