package com.example.weatherfashion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    static TextView temp_text;

    static void setText(String text_to_view){
        HomePage.temp_text.setText(text_to_view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        temp_text = (TextView) findViewById(R.id.temp_text);

        Facade new_facade = new Facade("Boulder","CO");
    }
}
