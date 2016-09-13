package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Food implements Buyable{


    public enum Type{
            SKULL,BONE,FLESH
        }
    private Type foodType;
    private int calories;
    private int price;
    private int count;

    public  Food(Type foodType, int calories, int price,int count){
        this.foodType=foodType;
        this.calories=calories;
        this.price=price;
        this.count = count;
    }


    public Type getType(){
        return this.foodType;
    }

    public int getPrice(){
        return this.price;
}

    public int getCalories() {return calories;}

    public int getCount() {return count;}

    public void increaseCount(){this.count++;}

    @Override
    public void buy() {
    //TODO
    }
}
