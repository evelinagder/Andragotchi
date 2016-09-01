package com.ljuboandeva.andragochi.model.pet;

import android.webkit.WebView;

import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Toy;

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
    private WebView petPicDefault;
    private WebView petPicEat;
    private WebView petPicHappy;
    private WebView petPicUnhappy;


    Dino(String name, String type){
        this.name=name;
        this.type=type;
        this.age=START_AGE;
        this.health=MAX_HEALTH;
        this.happiness=MAX_HAPPINESS;
        this.fill=MAX_FILL;
        this.cleanliness=MAX_CLEANLINESS;

    }

    public void eat(Food food){
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
    public void play(Toy toy){
        //TODO
    }
    public void die(){
        //TODO
    }
    public void getDirty(){
        //TODO
    }
    public void poop(){
        //TODO
    }
}
