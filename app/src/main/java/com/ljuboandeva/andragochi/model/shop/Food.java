package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Food implements Buyable{


    public enum Name{
            SKULL,BONE,FLESH
        }
            final private Name name;
            final private int calories;
            final private int price;
            private int count;

    //final?
  public  Food(Name name, int calories, int price){
        this.name=name;
        this.calories=calories;
        this.price=price;
    }
    public Name getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
}

    public int getCalories() {
        return calories;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void buy() {
    //TODO
    }
}
