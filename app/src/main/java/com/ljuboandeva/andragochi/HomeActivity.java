package com.ljuboandeva.andragochi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    Button tempLogOut; // go out!
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
        tempLogOut= (Button) findViewById(R.id.button_tempLogOut);
        petName= (TextView) findViewById(R.id.textView_name) ;
        happiness=(TextView)findViewById(R.id.textView_play) ;
        health=(TextView)findViewById(R.id.textView_health) ;
        fill=(TextView)findViewById(R.id.textView_food);
        cleanliness=(TextView)findViewById(R.id.textView_clean) ;

        petName.setText(user.getPet().getName());

        tempLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = HomeActivity.this.getSharedPreferences("Andragochi", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("logged_in", false);
                editor.commit();
                Toast.makeText(HomeActivity.this,"Logged out",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(HomeActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this, ShopActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(HomeActivity.this).getUser(user.getUsername()));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
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
