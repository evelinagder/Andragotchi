package com.ljuboandeva.andragochi.model.model.players;

import com.ljuboandeva.andragochi.model.model.pet.Dino;
import com.ljuboandeva.andragochi.model.model.shop.Food;
import com.ljuboandeva.andragochi.model.model.shop.Medicine;

/**
 * Created by Evelina on 8/25/2016.
 */
public class User {
        private static final int START_MONEY=100;
    //start money?
       private final String username;
        private int age;
        private String password;
        private String name;
        private int money;
        private int difficultyLevel;
        Dino dragon;

        // ot google profile
    //inventory collection link to shop inventory

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
