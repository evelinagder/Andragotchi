package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Food extends Buyable{

    public enum Type{
            SKULL,BONE,FLESH
        }
    private Type foodType;
    private int calories;
    private int price;
    private int count;

    public  Food(Type foodType, int price, int calories,int count){
        this.foodType=foodType;
        this.calories=calories;
        this.price=price;
        this.count = count;
    }

    public String getType(){ return this.foodType.toString(); }

    @Override
    public int getBonus() { return calories; }

    public int getPrice(){
        return this.price;
}

    public int getCalories() {return calories;}

    public int getCount() {return count;}

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount(){this.count+=1;}

    public void decreaseCount(){ this.count--; }
}
