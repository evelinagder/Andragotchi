package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
=======
import android.view.View;
import android.widget.Button;
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class DifficultyActivity extends AppCompatActivity {

    Button easy;
    Button medium;
    Button hard;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dfficulty);
        easy=(Button)findViewById(R.id.button_easy);
        medium= (Button)findViewById(R.id.button_medium);
        hard=(Button)findViewById(R.id.button_hard);
        user= (User) getIntent().getExtras().get("loggedUser");


        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Log.e("USER",user.getUsername());
                UsersManager.setUserDifficulty(user,"easy");
                Log.e("DIF",user.getDifficultyLevel());
                Intent intent= new Intent(DifficultyActivity.this,PetChoiceActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(DifficultyActivity.this).getUser(user.getUsername()));
                startActivity(intent);
=======
                String difficultyChoice="easy";
                UsersManager.setUserDifficulty(user,difficultyChoice);
                Intent intent= new Intent(DifficultyActivity.this,PetChoiceActivity.class);
               startActivity(intent);
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String difficultyChoice="medium";
                UsersManager.setUserDifficulty(user,difficultyChoice);
                Intent intent= new Intent(DifficultyActivity.this,PetChoiceActivity.class);
<<<<<<< HEAD
                intent.putExtra("loggedUser", UsersManager.getInstance(DifficultyActivity.this).getUser(user.getUsername()));
=======
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c
                startActivity(intent);

            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String difficultyChoice = "hard";
                UsersManager.setUserDifficulty(user,difficultyChoice);
                Intent intent = new Intent(DifficultyActivity.this, PetChoiceActivity.class);
<<<<<<< HEAD
                intent.putExtra("loggedUser", UsersManager.getInstance(DifficultyActivity.this).getUser(user.getUsername()));
=======
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c
                startActivity(intent);
            }
        });
    }
}
