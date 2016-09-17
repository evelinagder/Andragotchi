package com.ljuboandeva.andragochi.model.players;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.ljuboandeva.andragochi.model.pet.Pet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Evelina on 8/26/2016.
 */

public class UsersManager {

    private static UsersManager ourInstance;
    private HashMap<String, User> users;

    public static UsersManager getInstance(Activity activity) {
        if(ourInstance == null){
            ourInstance = new UsersManager(activity);
        }
        return ourInstance;
    }

    private UsersManager(Activity activity) {

        users = new HashMap<>();
        String json = activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getString("registeredUsers", "no users");
        try {
            JSONArray arr = new JSONArray(json);
            for(int i = 0; i < arr.length(); i++){
                JSONObject obj = arr.getJSONObject(i);
                User user = new User(obj.getString("username"), obj.getString("password"), obj.getString("email"));
                user.setDifficultyLevel(obj.getString("difficulty"));
                user.setMoney(obj.getInt("money"));
                Pet pet = new Pet(obj.getString("petType"), obj.getString("petName"));
                pet.setAge(obj.getInt("petAge"));
                pet.setHealth(obj.getInt("petHealth"));
                pet.setCleanliness(obj.getInt("petCleanliness"));
                pet.setHappiness(obj.getInt("petHappiness"));
                pet.setFill(obj.getInt("petFill"));
                for (int j=0;i<user.getFoods().size();i++) {
                    user.getFoods().get(i).setCount(obj.getInt("food"+j));
                }
                for (int j=0;i<user.getToys().size();i++) {
                    user.getToys().get(i).setCount(obj.getInt("toy"+j));
                }
                for (int j=0;i<user.getMeds().size();i++) {
                    user.getMeds().get(i).setCount(obj.getInt("med"+j));
                }
                user.setPet(pet);
                users.put(user.getUsername(), user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean existsUser(String username) {
        return users.containsKey(username);
    }

    public void registerUser(Activity activity, String username, String pass1, String email) {
        User user = new User(username, pass1,email);
        users.put(username, user);
        saveUsers(activity);
    }

    public boolean validalteLogin(String username, String password) {
        if (!existsUser(username)){
            Log.e("F", "user does not exist in map");
            return false;
        }
        if(!users.get(username).getPassword().equals(password)){
            Log.e("F","user pass is wrong");
            return false;
        }
        return true;
    }

    public User getUser(String username){
        return users.get(username);
    }

    public void unregister(Activity activity,User user){
        users.remove(user.getUsername());
        saveUsers(activity);
    }

    public void setUserDifficulty(Activity activity, User user, String difficultyChoice){
        user.setDifficultyLevel(difficultyChoice);
        User tempUser = user;
        users.remove(user);
        users.put(tempUser.getUsername(),tempUser);
        saveUsers(activity);
    }

    public void setUserPet(Activity activity, User user, Pet pet){
        user.setPet(pet);
        User tempUser = user;
        users.remove(user);
        users.put(tempUser.getUsername(),tempUser);
        saveUsers(activity);
    }

    public void buyFood (Activity activity, User user, int money, int position){
        user.setMoney(money);
        user.addFood(position);
        User tempUser = user;
        users.remove(user);
        users.put(tempUser.getUsername(),tempUser);
        saveUsers(activity);
    }

    public void buyToy(Activity activity, User user, int money, int position) {
        user.setMoney(money);
        user.addToy(position);
        User tempUser = user;
        users.remove(user);
        users.put(tempUser.getUsername(),tempUser);
        saveUsers(activity);
    }

    public void buyMedicine(Activity activity, User user, int money, int position) {
        user.setMoney(money);
        user.addMedicine(position);
        User tempUser = user;
        users.remove(user);
        users.put(tempUser.getUsername(),tempUser);
        saveUsers(activity);
    }

  public Pet getUserPet(String username){
        return users.get(username).getPet();
    }

    public void saveUsers(Activity activity) {
        SharedPreferences prefs = activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "registeredUsers";
        String value;
        JSONArray jsonUsers = new JSONArray();
        try {
            for (User u : users.values()) {
                JSONObject jobj = new JSONObject();
                jobj.put("username", u.getUsername());
                jobj.put("password", u.getPassword());
                jobj.put("email", u.getEmail());
                jobj.put("difficulty", u.getDifficultyLevel());
                jobj.put("money",u.getMoney());
                for (int i=0;i<u.getFoods().size();i++) {
                    jobj.put("food"+i, u.getFoods().get(i).getCount());
                }
                for (int i=0;i<u.getToys().size();i++) {
                    jobj.put("toy"+i, u.getToys().get(i).getCount());
                }
                for (int i=0;i<u.getMeds().size();i++) {
                    jobj.put("med"+i, u.getMeds().get(i).getCount());
                }
                if (u.getPet() != null) {
                    jobj.put("petName", u.getPet().getName());
                    jobj.put("petType", u.getPet().getType());
                    jobj.put("petAge", u.getPet().getAge());
                    jobj.put("petHealth", u.getPet().getHealth());
                    jobj.put("petCleanliness", u.getPet().getCleanliness());
                    jobj.put("petHappiness", u.getPet().getHappiness());
                    jobj.put("petFill", u.getPet().getFill());
                }
                jsonUsers.put(jobj);
            }
        } catch (JSONException e) {
            Log.e("JSON", e.getMessage());
        }
        value = jsonUsers.toString();
        Log.e("JSON", value);
        editor.putString(key, value);
        editor.apply();
    }
<<<<<<< HEAD


=======
>>>>>>> fdb61254a614d960da2c234709978cb38bd2e532
}
