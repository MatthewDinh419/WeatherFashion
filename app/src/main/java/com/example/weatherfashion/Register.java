package com.example.weatherfashion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class Register extends AppCompatActivity {

    String gender;
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked) {
                    gender = "male";
                    break;
                }
            case R.id.radio_female:
                if (checked) {
                    gender = "female";
                    break;
                }
        }
    }

    Button register_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input1 = findViewById(R.id.nameInput);
                final String name = input1.getEditableText().toString();
                EditText input2 = findViewById(R.id.ageInput);
                final int age = Integer.parseInt(input2.getEditableText().toString());
                EditText input3 = findViewById(R.id.cityInput);
                final String city = input3.getEditableText().toString();
                EditText input4 = findViewById(R.id.stateInput);
                final String state = input4.getEditableText().toString();
                User temp_user = new User(name, age, city, state, gender);
                Facade.new_user = temp_user;
                Intent i = new Intent(Register.this, HomePage.class);
                startActivity(i);
            }
        });
    }


}
