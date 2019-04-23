package com.example.weatherfashion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;


public class GeneralOutfit extends AppCompatActivity {
    private static TextView clothing_text;

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
    }
}
