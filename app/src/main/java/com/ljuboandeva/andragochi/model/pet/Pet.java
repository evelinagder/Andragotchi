package com.ljuboandeva.andragochi.model.pet;

import android.webkit.WebView;
import android.widget.ImageView;
import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Toy;
import java.io.Serializable;


/**
 * Created by Evelina on 8/26/2016.
 */
public class Pet implements Serializable {

    private static final int START_AGE=0;
    private static final int MIN_FILL=0;
    private static final int MIN_HEALTH=0;
    private static final int MIN_HAPPINESS=0;
    private static final int MIN_CLEANLINESS=0;

    private static final int MAX_HEALTH=100;
    private static final int MAX_HAPPINESS=100;
    private static final int MAX_FILL=100;
    private static final int MAX_CLEANLINESS=100;
    private String type;
    private String name;
    private int age;
    private int health;
    private int happiness;
    private int fill;
    private int cleanliness;
    private ImageView imageHome;
    private WebView petPicEat;
    private WebView petPicHappy;
    private WebView petPicUnhappy;

    public Pet(String type, String name){

        this.type=type;
        this.age=START_AGE;
        this.health=MAX_HEALTH;
        this.happiness=MAX_HAPPINESS;
        this.fill=MAX_FILL;
        this.cleanliness=MAX_CLEANLINESS;
        this.name=name;
    }



    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getFill() {
        return fill;
    }

    public void setFill(int fill) {
        this.fill = fill;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
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
