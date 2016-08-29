package com.ljuboandeva.andragochi.model.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Food {
            final private String name;
            final private int calories;
            final private int price;
            private int count;

    //final?
    Food(String name, int calories, int price){
        this.name=name;
        this.calories=calories;
        this.price=price;
    }
}
