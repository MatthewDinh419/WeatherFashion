package com.example.weatherfashion;

import java.util.ArrayList;

public interface GeocodeResponse{
    void onResponseReceived(ArrayList<Double> coord_response_temp);
}
