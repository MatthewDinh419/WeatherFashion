package com.example.weatherfashion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    static TextView temp_text;
    static TextView location_text;

    static void setText(String text_to_view, String City, String State){

        HomePage.temp_text.setText(text_to_view);
        String proper_loc_text = City + ", " + State;
        HomePage.location_text.setText(proper_loc_text);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        temp_text = (TextView) findViewById(R.id.temp_text);
        location_text = findViewById(R.id.location_text);
        temp_text.setKeyListener(null);
        location_text.setKeyListener(null);

        Facade.UpdateWeather();
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        Intent i = new Intent(HomePage.this, HomePage.class);
                        startActivity(i);
                        break;
                    case  R.id.navigation_clothing:
                        Intent j = new Intent(HomePage.this, GeneralOutfit.class);
                        startActivity(j);
                        break;
                    case R.id.navigation_profile:
                        Intent k = new Intent(HomePage.this, Profile.class);
                        startActivity(k);
                        break;
                }
                return true;
            }
        });
    }


}
