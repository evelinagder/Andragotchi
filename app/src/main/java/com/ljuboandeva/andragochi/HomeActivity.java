package com.ljuboandeva.andragochi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;


import java.util.Random;

public class HomeActivity extends MusicActivity  {
    public static final int DECREASE_VALUE=5;
    public static final int DECREASE_FUN=15;
    public static final int DECREASE_FILL=10;
    public static final int DECREASE_HEALTH=40;
    public static final int BIG_BONUS_MONEY=6;
    public static final int SMALL_BONUS_MONEY=4;
    private static final int REQUEST_CODE_HOME = 2;

    User user;
    Pet pet;
    Button clean;
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
    WebView itemAnimation;
    ImageView shit;
    WebView broom;
    TextView money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user = (User) getIntent().getExtras().get("loggedUser");
        pet = user.getPet();
        clean = (Button) findViewById(R.id.button_clean);
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
        shit = (ImageView) findViewById(R.id.shit);
        broom = (WebView) findViewById(R.id.broom);
        money = (TextView) findViewById(R.id.textView_money);

        int alarmType = AlarmManager.ELAPSED_REALTIME_WAKEUP;
        long timeOrLengthofWait = 300000;
        int requestCode = (int) System.currentTimeMillis();
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
                intent.putExtra("from", "home");
                startActivity(intent);
            }
        });


        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, InventoryActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                intent.putExtra("from", "home");
                startActivityForResult(intent, REQUEST_CODE_HOME);
            }
        });


        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                intent.putExtra("from", "home");
                startActivity(intent);
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pet.getCleanliness() == 100) {
                    Toast.makeText(HomeActivity.this, "I'm clean already!", Toast.LENGTH_SHORT).show();
                } else {
                    pet.setCleanliness(100);
                    UsersManager.getInstance(HomeActivity.this).setUserPet(HomeActivity.this, user, pet);

                    AsyncTask<Void, Void, Void> clean = new AsyncTask<Void, Void, Void>() {
                        @Override
                        protected Void doInBackground(Void... params) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            return null;
                        }

                        @Override
                        protected void onPreExecute() {
                            broom.setBackgroundColor(0x00000000);
                            broom.loadUrl("file:///android_asset/cleaning.gif");
                            broom.setVisibility(View.VISIBLE);
                        }

                        @Override
                        protected void onPostExecute(Void aVoid) {
                            cleanliness.setText(String.valueOf(pet.getCleanliness()));
                            shit.setVisibility(View.INVISIBLE);
                            broom.setVisibility(View.INVISIBLE);
                        }
                    }.execute();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==REQUEST_CODE_HOME && resultCode==RESULT_OK){
            final String result = data.getData().toString();
            itemAnimation = (WebView) findViewById(R.id.item_animation);
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPreExecute() {
                    itemAnimation.setBackgroundColor(0x00000000);
                    itemAnimation.setVisibility(View.VISIBLE);
                    switch (result) {
                        case "NEEDLE":
                            itemAnimation.loadUrl("file:///android_asset/vaccine.gif");
                            break;
                        case "TABLET":
                            itemAnimation.loadUrl("file:///android_asset/pill.gif");
                            break;
                        case "BONE":
                            itemAnimation.loadUrl("file:///android_asset/bone.gif");
                            break;
                        case "SKULL":
                            itemAnimation.loadUrl("file:///android_asset/skull.gif");
                            break;
                        case "FLESH":
                            itemAnimation.loadUrl("file:///android_asset/flesh.gif");
                            break;
                    }
                }

                @Override
                protected void onPostExecute(Void Void) {
                    itemAnimation.setVisibility(View.INVISIBLE);
                    itemAnimation.loadUrl("file://android_asset/transp.gif");
                    User usr = (User) getIntent().getExtras().get("loggedUser");
                    user = UsersManager.getInstance(HomeActivity.this).getUser(usr.getUsername());
                    pet = user.getPet();
                    petName.setText(pet.getName());
                    happiness.setText(String.valueOf(pet.getHappiness()));
                    cleanliness.setText(String.valueOf(pet.getCleanliness()));
                    fill.setText(String.valueOf(pet.getFill()));
                    health.setText(String.valueOf(pet.getHealth()));
                    money.setText(String.valueOf(user.getMoney()));
                }
            }.execute();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(UpdateAlarmReceiver, new IntentFilter("ALARM"));
        Log.e("myTag", "Resume and register Reciever");

        petName.setText(pet.getName());
        happiness.setText(String.valueOf(pet.getHappiness()));
        cleanliness.setText(String.valueOf(pet.getCleanliness()));
        fill.setText(String.valueOf(pet.getFill()));
        health.setText(String.valueOf(pet.getHealth()));
        money.setText(String.valueOf(user.getMoney()));
        if(pet.isShit()){ shit.setVisibility(View.VISIBLE); }
        else {shit.setVisibility(View.INVISIBLE);}
    }
    @Override
    public void onPause() {
        super.onPause();
        unregisterReceiver(UpdateAlarmReceiver);

    }


    private BroadcastReceiver UpdateAlarmReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            if(pet.getHealth()<=0){
                Intent intentD = new Intent(HomeActivity.this, DieActivity.class);
                intentD.putExtra("loggedUser",user);
                startActivity(intentD);

            }
            pet.setHappiness(pet.getHappiness()-DECREASE_FUN);
            pet.setCleanliness(pet.getCleanliness()-DECREASE_VALUE);
            pet.setFill(pet.getFill()-DECREASE_FILL);
            Random r= new Random();
            int random = r.nextInt(24);
            if(random==0){
              pet.setHealth(pet.getHealth()-DECREASE_HEALTH);
            }
            if(pet.getHappiness()<30 || pet.getFill() < 30 || pet.getHealth() < 30 || pet.getCleanliness()<30) {
                pet.setHealth(pet.getHealth() - DECREASE_VALUE);
            }
            if(pet.getHealth()<0)pet.setHealth(0);
            if(pet.getHappiness()<0)pet.setHappiness(0);
            if(pet.getFill()<0)pet.setFill(0);
            if(pet.getCleanliness()<0)pet.setCleanliness(0);
            happiness.setText(String.valueOf(pet.getHappiness()));
            cleanliness.setText(String.valueOf(pet.getCleanliness()));
            fill.setText(String.valueOf(pet.getFill()));
            health.setText(String.valueOf(pet.getHealth()));
            shit.setVisibility(View.VISIBLE);
            if(pet.getHappiness()>30 && pet.getFill()>30 && pet.getHealth()>30 && pet.getCleanliness()>30){
                user.setMoney(user.getMoney()+BIG_BONUS_MONEY*user.getDifficultyLevel());
                money.setText(String.valueOf(user.getMoney()));
                Toast.makeText(HomeActivity.this,"You received the Big bonus!",Toast.LENGTH_SHORT).show();
            }
            else{
                user.setMoney(user.getMoney()+SMALL_BONUS_MONEY*user.getDifficultyLevel());
                money.setText(String.valueOf(user.getMoney()));
                Toast.makeText(HomeActivity.this,"You received the Small bonus!",Toast.LENGTH_SHORT).show();

            }
            UsersManager.getInstance(HomeActivity.this).setUserPet(HomeActivity.this,user,pet);
        }
    };
}
