package com.example.weatherfashion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        //DARK SKY AND GEOCODE TESTING
//        //Convert city and state to coordinates
//        Geocode geoguess = new Geocode("Boulder", "CO");
//        ArrayList<Double> coord = geoguess.getCoordinates(new GeocodeResponse() {
//            @Override
//            public void onResponseReceived(ArrayList<Double> coord_response) {
//                System.out.println("Lat: " + coord_response.get(0));
//                System.out.println("Long: " + coord_response.get(1));
//            }
//        });
//        //Should pass in new coordinates to darksky object
//        Darksky darksky = new Darksky(37.8267,-122.4233);
//        darksky.setWeather();
    }

}
