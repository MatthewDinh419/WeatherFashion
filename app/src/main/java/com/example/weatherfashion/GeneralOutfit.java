package com.example.weatherfashion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class GeneralOutfit extends AppCompatActivity {
    private static TextView clothing_text;

    //Updates text information with clothing to wear
    public static void setTextView(ArrayList<Clothing> clothing_to_wear){
        for(int i = 0; i < clothing_to_wear.size(); i++){
            GeneralOutfit.clothing_text.append(clothing_to_wear.get(i).get_clothing_type());
            GeneralOutfit.clothing_text.append("\n\r");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_outfit);

        GeneralOutfit.clothing_text = findViewById(R.id.clothing_text);
        GeneralOutfit.clothing_text.setKeyListener(null);

        Facade.UpdateOutfits();


        // Bottom navigation bar that maps to home and profile
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        Intent i = new Intent(GeneralOutfit.this, HomePage.class);
                        startActivity(i);
                        break;
                    case  R.id.navigation_clothing:
                        Intent j = new Intent(GeneralOutfit.this, GeneralOutfit.class);
                        startActivity(j);
                        break;
                    case R.id.navigation_profile:
                        Intent k = new Intent(GeneralOutfit.this, Profile.class);
                        startActivity(k);
                        break;
                }
                return false;
            }
        });
    }
}
