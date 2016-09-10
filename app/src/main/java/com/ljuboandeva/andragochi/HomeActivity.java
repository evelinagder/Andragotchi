package com.ljuboandeva.andragochi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class HomeActivity extends AppCompatActivity {
    User user;
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
    // TODO threads that change the state
    //TODO sync time  with GMT
    //TODO save on stop() with shared pfres

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        user=(User) getIntent().getExtras().get("loggedUser");
        feed = (Button)findViewById(R.id.button_feed);
        clean= (Button)findViewById(R.id.button_clean);
        medicine= (Button)findViewById(R.id.button_medicine);
        shop=(Button)findViewById(R.id.button_shop);
        inventory= (ImageButton) findViewById(R.id.button_inventory);
        settings= (ImageButton) findViewById(R.id.button_settings);
        goOut= (Button) findViewById(R.id.button_go_out);
        petName= (TextView) findViewById(R.id.textView_name) ;
        happiness=(TextView)findViewById(R.id.textView_play) ;
        health=(TextView)findViewById(R.id.textView_health) ;
        fill=(TextView)findViewById(R.id.textView_food);
        cleanliness=(TextView)findViewById(R.id.textView_clean) ;

        petName.setText(user.getPet().getName());

        goOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, OutChoiceActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, ShopActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, InventoryActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, SettingsActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });
        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO fill.setText...
            }
        });

        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO cleanliness.setText..
            }
        });
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO health.setText..
            }
        });
        //TODO change tempLogOut to GoOut!
    }
}
