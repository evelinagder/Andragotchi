package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.util.ArrayList;

public class PlaygroundActivity extends MusicActivity {

    String outChoice;
    Button home;
    Button shop;
    Button play;
    ImageButton inventory;
    ImageButton settings;
    User user;
    Pet pet;
    TextView petName;
    TextView happiness;
    TextView fill;
    TextView health;
    TextView cleanliness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_playground);
        play = (Button)findViewById(R.id.button_play) ;
        home = (Button) findViewById(R.id.button_home);
        user=(User) getIntent().getExtras().get("loggedUser");
        pet=user.getPet();
        shop=(Button)findViewById(R.id.button_shop_playground);
        inventory= (ImageButton) findViewById(R.id.button_inventory_playground);
        settings= (ImageButton) findViewById(R.id.button_settings_playground);
        petName= (TextView)findViewById(R.id.textView9);
        happiness= (TextView)findViewById(R.id.textView_play);
        fill= (TextView)findViewById(R.id.textView_food) ;
        cleanliness=(TextView)findViewById(R.id.textView_clean);
        health= (TextView)findViewById(R.id.textView_healthp);

        petName.setText(user.getPet().getName());

        outChoice = getIntent().getStringExtra("outChoice");
        switch (outChoice){
            case "park":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_park));
                break;
            case "pool":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_pool));
                break;
            case "sandbox":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_sandbox));
                break;
        }



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaygroundActivity.this,HomeActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PlaygroundActivity.this, ShopActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PlaygroundActivity.this, InventoryActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PlaygroundActivity.this, SettingsActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList <Toy>toys=user.getToys();
                int counter=0;
                switch (outChoice){

                    case "park":
                       for(int i =0;i<toys.size();i++) {
                           if (toys.get(i).getToyType().equals(Toy.Type.BALL)) {
                               pet.setHappiness(pet.getHappiness() + toys.get(i).getBonus());
                               toys.remove(i);
                               happiness.setText(pet.getHappiness()+"");
                               counter++;
                           } if(i==toys.size() &&counter==0){
                               Toast.makeText(PlaygroundActivity.this, "I don`t have a toy for this place!", Toast.LENGTH_SHORT).show();
                           }
                           counter=0;   
}                    
                        break;
                    case "pool":
                        for(int i =0;i<toys.size();i++) {
                            if (toys.get(i).getToyType().equals(Toy.Type.GIRDLE)) {
                                pet.setHappiness(pet.getHappiness() + toys.get(i).getBonus());
                                toys.remove(i);
                                happiness.setText(pet.getHappiness()+"");
                                counter++;
                            } if(i>=toys.size() &&counter==0){
                                counter=0;
                                Toast.makeText(PlaygroundActivity.this, "I don`t have a toy for this place!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        break;
                    case "sandbox":
                        for(int i =0;i<toys.size();i++) {
                            if (toys.get(i).getToyType().equals(Toy.Type.SHOVEL)) {
                                pet.setHappiness(pet.getHappiness() + toys.get(i).getBonus());
                                toys.remove(i);
                                happiness.setText(pet.getHappiness()+"");
                                counter++;
                            } if(i>=toys.size() &&counter==0){
                                counter=0;
                                Toast.makeText(PlaygroundActivity.this, "I don`t have a toy for this place!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        break;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        happiness.setText(String.valueOf(pet.getHappiness()));
        cleanliness.setText(String.valueOf(pet.getCleanliness()));
        fill.setText(String.valueOf(pet.getFill()));
        health.setText(String.valueOf(pet.getHealth()));
    }
}
