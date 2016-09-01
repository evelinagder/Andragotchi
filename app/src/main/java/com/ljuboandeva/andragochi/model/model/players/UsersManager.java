package com.ljuboandeva.andragochi.model.model.players;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Evelina on 8/26/2016.
 */
public class UsersManager {

    private static UsersManager ourInstance;
    HashMap<String, User> users;

    public static UsersManager getInstance(Activity activity) {
        if(ourInstance == null){
            ourInstance = new UsersManager(activity);
        }
        return ourInstance;
    }

    private UsersManager(Activity activity) {

        users = new HashMap<>();
        String json = activity.getSharedPreferences("Library", Context.MODE_PRIVATE).getString("registerredUsers", "no users");
        Log.e("LOADED USERS", json);

        try {
            JSONArray arr = new JSONArray(json);
            for(int i = 0; i < arr.length(); i++){
                JSONObject obj = arr.getJSONObject(i);
                User user = new User(obj.getString("username"),
                        obj.getString("password"),
                        obj.getString("email"));
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


        SharedPreferences prefs = activity.getSharedPreferences("Library",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        String key = "registerredUsers";
        String value = "...";//JSON format containing all users from the collection
        JSONArray jsonUsers = new JSONArray();
        try {
            for (User u : users.values()) {
                JSONObject jobj = new JSONObject();
                jobj.put("username", u.getUsername());
                jobj.put("password", u.getPassword());
                jsonUsers.put(jobj);
            }
        }
        catch(JSONException e){
            Log.e("JSON", e.getMessage());
        }
        value = jsonUsers.toString();
        Log.e("JSON", value);
        editor.putString(key, value);
        editor.commit();
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
    public void unregister(User user){
        users.remove(user.getUsername());
    }

}
