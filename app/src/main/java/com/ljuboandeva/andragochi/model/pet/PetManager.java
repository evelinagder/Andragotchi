package com.ljuboandeva.andragochi.model.pet;

import com.ljuboandeva.andragochi.model.players.User;

/**
 * Created by Evelina on 9/1/2016.
 */
public class PetManager {
    private static PetManager ourInstance;
    Pet pet;

    public static PetManager getInstance(String petType) {
        ourInstance=new PetManager(petType);
        return ourInstance;
    }

    private PetManager(String petType) {
        pet= new Pet(petType);
    }

    public Pet getPet(){
        return this.pet;
    }
    public void setUserPet(User user, Pet pet){
        user.setPet(pet);
    }
    public void setPetName(String petName){
        this.pet.setName(petName);
    }
}
