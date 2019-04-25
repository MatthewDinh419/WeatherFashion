package com.example.weatherfashion;

public class User{
    private String name;
    private int age;
    private String city;
    private String state;
    private String gender;

    User(String new_name, int new_age, String new_city, String new_state, String new_gender){
        name = new_name;
        age = new_age;
        city = new_city;
        state = new_state;
        gender = new_gender;
    }

    public String get_name(){
        return name;
    }

    public int get_age(){
        return age;
    }

    public String get_city(){
        return city;
    }

    public String get_state(){
        return state;
    }

    public String get_gender(){
        return gender;
    }
}
