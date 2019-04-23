package com.example.weatherfashion;
import java.util.ArrayList;

public class Clothing {

    public static ArrayList<Clothing> GenerateOutfit(double temperature, User person){
        ArrayList<Clothing> clothing_to_wear = new ArrayList<>();
        if(person.gender == "Male") {
            if (temperature <= 50.0) {
                clothing_to_wear.add(new Joggers());
                clothing_to_wear.add(new Hoodie());
            } else if (temperature > 50 && temperature <= 65) {
                clothing_to_wear.add(new T_shirt());
                clothing_to_wear.add(new Jeans());
            } else {
                clothing_to_wear.add(new T_shirt());
                clothing_to_wear.add(new Shorts());
            }
        }
        else{ //Female
            if (temperature <= 50.0) {
                clothing_to_wear.add(new Joggers());
                clothing_to_wear.add(new Hoodie());
            } else if (temperature > 50 && temperature <= 65) {
                clothing_to_wear.add(new Blouse());
                clothing_to_wear.add(new Jeans());
            } else {
                clothing_to_wear.add(new Blouse());
                clothing_to_wear.add(new Skirt());
            }
        }
        return clothing_to_wear;
    }

    public String get_clothing_type(){
        return "Base Clothing";
    }
}

class Jeans extends Clothing{
    @Override
    public String get_clothing_type(){
        return "Jeans";
    }
}

class Hoodie extends Clothing{
    @Override
    public String get_clothing_type(){
        return "Hoodie";
    }
}

class Joggers extends Clothing{
    @Override
    public String get_clothing_type(){
        return "Joggers";
    }
}

class T_shirt extends Clothing{
    @Override
    public String get_clothing_type(){
        return "T-shirt";
    }
}

class Shorts extends Clothing{
    @Override
    public String get_clothing_type(){
        return "Shorts";
    }
}

class Skirt extends Clothing{
    @Override
    public String get_clothing_type(){
        return "Skirt";
    }
}

class Blouse extends Clothing{
    @Override
    public String get_clothing_type(){
        return "Blouse";
    }
}