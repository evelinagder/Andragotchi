package com.ljuboandeva.andragochi.playersAndPet;

import com.ljuboandeva.andragochi.playersAndPet.Dino;
import com.ljuboandeva.andragochi.shop.Food;

/**
 * Created by Evelina on 8/25/2016.
 */
public class User {
        private static final int START_MONEY=100;
    //start money?
       private final String username;
        private String password;
        private String name;
        private int money;
        private int difficultyLevel;
        Dino dragon;

        User(String username, String password){
            this.username=username;
            this.password=password;

        }
        public void addMoney(int money){
            this.money += money;
        }

        //default setter and getters
        public void clean(){
            //TODO
        }
        public void takeOut(){
            //TODO
        }
        public void takeHome(){
            //TODO
        }
        public void Feed(Food food){
            //TODO
        }
        public void giveMedicine(Medicine meds){
            //TODO
        }
}
