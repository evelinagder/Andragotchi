package com.ljuboandeva.andragochi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class WelcomeActivity extends MusicActivity {

    ImageButton signIn;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        signIn=(ImageButton)findViewById(R.id.button_sign);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(WelcomeActivity.this.getSharedPreferences("Andragochi",Context.MODE_PRIVATE).getString("currentUser", null)!=null) {
                    user = getCurrentUser(WelcomeActivity.this);
                    Log.e("USER", user.getUsername());
                }
                maintainLogin(WelcomeActivity.this);
            }
        });

    }
    //gets the boolean value from file "Users", and checks if true-user is logged in, if false -to login activity
    public void maintainLogin(Context activity){
        boolean logged_in=activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getBoolean("logged_in", false);

        if (logged_in) {
            Toast.makeText(WelcomeActivity.this,"Going to Home",Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(WelcomeActivity.this, HomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("loggedUser", UsersManager.getInstance(WelcomeActivity.this).getUser(user.getUsername()));
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
        String username=activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getString("currentUser", null);
        User user=UsersManager.getInstance(WelcomeActivity.this).getUser(username);
        return user;
    }
}
