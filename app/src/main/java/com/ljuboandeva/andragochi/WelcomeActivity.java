package com.ljuboandeva.andragochi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

    ImageButton signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        signIn=(ImageButton)findViewById(R.id.button_sign);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maintainLogin(WelcomeActivity.this);


            }
        });

    }
    //gets the boolean value from file "Users", and checks if true-user is logged in, if false -to login activity
    public void maintainLogin(Context activity){
        boolean logged_in=activity.getSharedPreferences("Users", Context.MODE_PRIVATE).getBoolean("logged_in", false);

        if (logged_in) {
            Toast.makeText(WelcomeActivity.this,"Going to Home",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(WelcomeActivity.this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(intent);
               finish();

        } else {
            Toast.makeText(WelcomeActivity.this,"Going to Login",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(WelcomeActivity.this, LoginActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
        }
    }
}
