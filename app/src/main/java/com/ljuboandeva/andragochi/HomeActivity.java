package com.ljuboandeva.andragochi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ljuboandeva.andragochi.fragments_inventory.FoodFragment;
import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.takingCare.CareFragment;

public class HomeActivity extends AppCompatActivity implements FoodFragment.OnFragmentInteractionListener {
    public static final int DECREASE_VALUE=5;
    public static final int BONUS_MONEY=10;

    User user;
    Pet pet;
    Button feed;
    Button clean;
    Button medicine;
    Button shop;
    ImageButton inventory;
    ImageButton settings;
    Button goOut;
    TextView petName;
    TextView happiness;
    TextView health;
    TextView fill;
    TextView cleanliness;
    ImageView petImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user = (User) getIntent().getExtras().get("loggedUser");
        pet = user.getPet();
        feed = (Button) findViewById(R.id.button_feed);
        clean = (Button) findViewById(R.id.button_clean);
        medicine = (Button) findViewById(R.id.button_medicine);
        shop = (Button) findViewById(R.id.button_shop);
        inventory = (ImageButton) findViewById(R.id.button_inventory);
        settings = (ImageButton) findViewById(R.id.button_settings);
        goOut = (Button) findViewById(R.id.button_go_out);
        petName = (TextView) findViewById(R.id.textView_name);
        happiness = (TextView) findViewById(R.id.textView_play);
        health = (TextView) findViewById(R.id.textView_health);
        fill = (TextView) findViewById(R.id.textView_food);
        cleanliness = (TextView) findViewById(R.id.textView_clean);
        petImage = (ImageView) findViewById(R.id.pet_image_home);

        int alarmType =AlarmManager.ELAPSED_REALTIME_WAKEUP;
        long timeOrLengthofWait = AlarmManager.INTERVAL_HOUR;
        int requestCode= (int) System.currentTimeMillis();
        Intent myIntent = new Intent("ALARM");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(HomeActivity.this, requestCode, myIntent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setInexactRepeating(alarmType, timeOrLengthofWait, timeOrLengthofWait, pendingIntent);

        boolean alarmUp = (PendingIntent.getBroadcast(HomeActivity.this, 0,
                new Intent("ALARM"),
                PendingIntent.FLAG_NO_CREATE) != null);

        if (alarmUp) {
            Log.d("myTag", "Alarm is already active");
        }


        switch (pet.getType()) {
            case "Drago":
                petImage.setBackgroundResource(R.drawable.drago_home);
                break;
            case "Rhina":
                petImage.setBackgroundResource(R.drawable.rhina_home);
                break;
            case "Rex":
                petImage.setBackgroundResource(R.drawable.rex_home);
                break;
        }

        goOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, OutChoiceActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ShopActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InventoryActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
                finish();
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, CareActivity.class);
                intent.putExtra("type", "FOOD");
                startActivity(intent);


            }
        });
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO cleanliness.setText.. remove poop
            }
        });
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, CareActivity.class);
                intent.putExtra("type", "MEDICINE");
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(UpdateAlarmReceiver, new IntentFilter("ALARM"));
        Log.e("myTag", "Resume and register Reciever");
        petName.setText(pet.getName());
        happiness.setText(String.valueOf(pet.getHappiness()));
        cleanliness.setText(String.valueOf(pet.getCleanliness()));
        fill.setText(String.valueOf(pet.getFill()));
        health.setText(String.valueOf(pet.getHealth()));
    }
    @Override
    protected void onPause() {
        unregisterReceiver(UpdateAlarmReceiver);
        super.onPause();
    }

    private BroadcastReceiver UpdateAlarmReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.e("myTag", "pet happiness-5");
            if(pet.getHappiness()==0 || pet.getCleanliness()==0 || pet.getFill()==0 || pet.getHealth()==0){
                Intent intentD = new Intent(HomeActivity.this, DieActivity.class);
                intentD.putExtra("loggedUser",user);
                startActivity(intentD);

            }
            pet.setHappiness(pet.getHappiness()-DECREASE_VALUE);
            pet.setCleanliness(pet.getCleanliness()-DECREASE_VALUE);
            pet.setHealth(pet.getHealth()-DECREASE_VALUE);
            pet.setFill(pet.getFill()-DECREASE_VALUE);
            happiness.setText(String.valueOf(pet.getHappiness()));
            cleanliness.setText(String.valueOf(pet.getCleanliness()));
            fill.setText(String.valueOf(pet.getFill()));
            health.setText(String.valueOf(pet.getHealth()));
            if(pet.getHappiness()>=50){
                user.setMoney(user.getMoney()+BONUS_MONEY);
            }
            UsersManager.getInstance(HomeActivity.this).setUserPet(HomeActivity.this,user,pet);


        }
    };

    @Override
    public void onFragmentInteraction(int selectedItem) {

    }

}
