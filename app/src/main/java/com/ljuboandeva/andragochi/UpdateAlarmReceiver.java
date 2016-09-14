package com.ljuboandeva.andragochi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

/**
 * Created by Evelina on 9/14/2016.
 */
public class UpdateAlarmReceiver extends BroadcastReceiver {
    public static final int DECREASE_VALUE=5;
    public static final int BONUS_MONEY=10;
    @Override
    public void onReceive(Context context, Intent intent) {
        Pet pet=(Pet) intent.getExtras().get("pet");
        User user=(User) intent.getExtras().get("loggedUser");
        Log.e("Update", "pet happiness-5");
        pet.setHappiness(pet.getHappiness()-DECREASE_VALUE);
        if(pet.getHappiness()>=50){
       user.setMoney(user.getMoney()+BONUS_MONEY);
         }

        HomeActivity.changeText(String.valueOf(pet.getHappiness()));


    }

}
