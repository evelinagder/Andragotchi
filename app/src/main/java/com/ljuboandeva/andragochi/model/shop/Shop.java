package com.ljuboandeva.andragochi.model.shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Evelina on 8/29/2016.
 */
public class Shop {

    private ArrayList<Food> foods;
    private ArrayList<Medicine> medicines;
    private ArrayList<Toy> toys;

    private static Shop instance=null;

    public static Shop getInstance(){
        if(instance == null)
        {
            instance = new Shop();
        }
        return instance;
    }

    public Shop() {
        this.toys=new ArrayList<>();
        toys.add(new Toy(Toy.Type.BALL,15,15,32000));
        toys.add(new Toy(Toy.Type.GIRDLE,25,25,32000));
        toys.add(new Toy(Toy.Type.SHOVEL,40,40,32000));
        this.medicines = new ArrayList<>();
        medicines.add(new Medicine(Medicine.Type.TABLET,15,15,32000));
        medicines.add(new Medicine(Medicine.Type.NEEDLE,30,30,32000));
        this.foods = new ArrayList<>();
        foods.add(new Food(Food.Type.BONE,5,5,32000));
        foods.add(new Food(Food.Type.FLESH,10,10,32000));
        foods.add(new Food(Food.Type.SKULL,15,15,32000));
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Medicine> getMedicines() {
        return medicines;
    }

    public ArrayList<Toy> getToys() {
        return toys;
    }
}
