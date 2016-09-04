package com.ljuboandeva.andragochi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class WelcomeActivity extends AppCompatActivity {

    ImageButton signIn;
<<<<<<< HEAD
   User user;
=======
   // User user;
>>>>>>> a09ee51d036be01ce6556e9e9ffe9034b618066a


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        signIn=(ImageButton)findViewById(R.id.button_sign);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=getCurrentUser(WelcomeActivity.this);
                maintainLogin(WelcomeActivity.this);
<<<<<<< HEAD
=======
               // user= (User) getIntent().getExtras().get("loggedUser");
>>>>>>> a09ee51d036be01ce6556e9e9ffe9034b618066a

            }
        });

    }
    //gets the boolean value from file "Users", and checks if true-user is logged in, if false -to login activity
    public void maintainLogin(Context activity){
<<<<<<< HEAD
        boolean logged_in=activity.getSharedPreferences("Login", Context.MODE_PRIVATE).getBoolean("logged_in", false);
=======
        boolean logged_in=activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getBoolean("logged_in", false);
>>>>>>> a09ee51d036be01ce6556e9e9ffe9034b618066a

        if (logged_in) {
            Toast.makeText(WelcomeActivity.this,"Going to Home",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(WelcomeActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
<<<<<<< HEAD
            intent.putExtra("loggedUser", UsersManager.getInstance(WelcomeActivity.this).getUser(user.getUsername()));
=======
           // intent.putExtra("loggedUser", UsersManager.getInstance(WelcomeActivity.this).getUser(user.getUsername()));
>>>>>>> a09ee51d036be01ce6556e9e9ffe9034b618066a
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
    public  User getCurrentUser(Context activity){
        String username=activity.getSharedPreferences("Login", Context.MODE_PRIVATE).getString("currentUser", null);
        User user=UsersManager.getInstance(WelcomeActivity.this).getUser(username);
        Log.e("USERNAME?",username);
        return user;
    }
}
