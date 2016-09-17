package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Toy extends Buyable{

    public enum Type{
        BALL,GIRDLE,SHOVEL
    }
    private int price;
    private Type toyType;
    private int count;
    private int fun;

    public Toy(Type toyType, int price, int fun, int count){
        this.toyType=toyType;
        this.price=price;
        this.fun=fun;
        this.count=count;
    }

    public int getPrice() {
        return price;
    }

    public int getFun() {return fun;}

    public void increaseCount(){this.count++;}

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getType(){ return this.toyType.toString(); }

    @Override
    public int getBonus() { return fun; }
    public void decreaseCount(){
        this.count--;
    }
}
