package com.ljuboandeva.andragochi.model.players;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Medicine;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Evelina on 8/25/2016.
 */
public class User implements Serializable{
        private static final int START_MONEY=100;
        private final String username;
        private int age;
        private String password;
        private String email;
        private String name;
        private int money;
        private String difficultyLevel;
        Pet pet;

    private ArrayList<Food> foods;
    private ArrayList<Medicine> medicines;
    private ArrayList<Toy> toys;


        // ot google profile
    //inventory collection link to shop inventory

        public User(String username, String password,String email){
            this.username=username;
            this.password=password;
            this.email=email;
            this.money=START_MONEY;
            this.toys=new ArrayList<>();
            toys.add(new Toy(Toy.Type.BALL,15,15,0));
            toys.add(new Toy(Toy.Type.GIRDLE,25,25,0));
            toys.add(new Toy(Toy.Type.SHOVEL,40,40,0));
            this.medicines = new ArrayList<>();
            medicines.add(new Medicine(Medicine.Type.TABLET,15,15,0));
            medicines.add(new Medicine(Medicine.Type.NEEDLE,30,30,0));
            this.foods = new ArrayList<>();
            foods.add(new Food(Food.Type.BONE,5,5,0));
            foods.add(new Food(Food.Type.FLESH,10,10,0));
            foods.add(new Food(Food.Type.SKULL,15,15,0));

        }


        public void addMoney(int money){
            this.money += money;
        }

        public void clean(){
            //TODO
        }
        public void takeOut(){
            //TODO
        }
        public void takeHome(){
            //TODO
        }
        public void feed(Food food){
            //TODO
        }
        public void giveMedicine(Medicine meds){
            //TODO
        }

    public void setDifficultyLevel(String difficultyLevel){
        this.difficultyLevel=difficultyLevel;
    }
    public String getDifficultyLevel(){
        return this.difficultyLevel;
    }
    public Pet getPet() {
        return this.pet;
    }
    public boolean petExists(){return pet!=null;}
    public String getEmail() {
        return email;
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
}
