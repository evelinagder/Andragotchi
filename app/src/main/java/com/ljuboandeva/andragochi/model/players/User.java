package com.ljuboandeva.andragochi.model.players;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Medicine;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.util.HashMap;

/**
 * Created by Evelina on 8/25/2016.
 */
public class User {
        private static final int START_MONEY=100;
    //start money?
       private final String username;
        private int age;
        private String password;
        private String email;
        private String name;
        private int money;
        private int difficultyLevel;
        Pet pet;

    HashMap<Food.Name,Food> foods;
    HashMap<Medicine.Type,Medicine> meds;
    HashMap<Toy.Type,Toy> toys;


        // ot google profile
    //inventory collection link to shop inventory

        public User(String username, String password,String email){
            this.username=username;
            this.password=password;
            this.email=email;
            this.money=START_MONEY;
            foods=new HashMap<>();
            meds=new HashMap<>();
            toys= new HashMap<>();

        }

        public void setPet(Pet pet){
            this.pet=pet;
        }
        public String getUsername(){
            return username;
        }
        public String getPassword(){
            return password;
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
        // izpulniavat se pri select na item ot shop! v method buy
        public void addFood(Food food,int quantity){
            Food f= new Food(food.getName(),food.getCalories(),food.getPrice());
            f.setCount(quantity);
            foods.put(f.getName(),f);

        }
        public void addMedicine(Medicine medicine, int quantity){
            Medicine m= new Medicine(medicine.getType(),medicine.getPrice());
            m.setCount(quantity);
            meds.put(m.getType(),m);
        }
        public void addToy(Toy toy,int quantity){
            Toy t= new Toy(toy.getToyType(),toy.getPrice());
            toys.put(t.getToyType(),t);
        }

}
