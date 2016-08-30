package com.ljuboandeva.andragochi.model.model.players;

import java.util.HashMap;

/**
 * Created by Evelina on 8/26/2016.
 */
public class UsersManager {


    HashMap<String,User> users= new HashMap<>();

    public void registerUser(User user){
        if(!users.containsKey(user.getUsername())) {
            users.put(user.getUsername(), user);

        }
    }
    public boolean validateLogin(String username, String password) {
        if( users.containsKey(username)){
            User user=users.get(username);
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;

    }
    public void unregister(User user){
        users.remove(user.getUsername());
    }

}
