package com.ljuboandeva.andragochi.playersAndPet;

import com.ljuboandeva.andragochi.shop.Food;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Dino {

    private static final int START_AGE=0;
    private static final int MIN_FILL=0;
    private static final int MIN_HEALTH=0;
    private static final int MIN_HAPPINESS=0;
    private static final int MIN_CLEANLINESS=0;

    private static final int MAX_HEALTH=100;
    private static final int MAX_HAPPINESS=100;
    private static final int MAX_FILL=100;
    private static final int MAX_CLEANLINESS=100;
    //private static final int MAX_AGE=10; max age?
    private String type;
    private String name;
    private int age;
    private int health;
    private int happiness;
    private int fill;
    private int cleanliness;

    Dino(String name, String type){
        this.name=name;
        this.type=type;
        this.age=START_AGE;
        this.health=MAX_HEALTH;
        this.happiness=MAX_HAPPINESS;
        this.fill=MAX_FILL;
        this.cleanliness=MAX_CLEANLINESS;

    }
    public void dinoSleep(){
        //TODO
    }
    public void dinoEat(Food food){
        //TODO
    }
    public void getBored(){
        //TODO
    }
    public void getHungry(){
        //TODO
    }
    public void generateMoney(){
        //TODO
    }
    public void dinoPlay(Toy toy){
        //TODO
    }
    public void dinoDie(){
        //TODO
    }
    public void getDirty(){
        //TODO
    }
    public void poop(){
        //TODO
    }
}
