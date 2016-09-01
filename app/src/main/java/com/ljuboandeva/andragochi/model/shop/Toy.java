package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Toy implements Buyable{
    public enum Type{
        BALL,GIRDLE,SHOVEL
    }
    private int price;
    private Type toyType;
    private int count;
    //in user no count -only one toy?
    public Toy(Type toyType, int price){
        this.toyType=toyType;
        this.price=price;
    }

    public int getPrice() {
        return price;
    }

    public Type getToyType() {
        return toyType;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public void buy() {
    //TODO
    }
}
