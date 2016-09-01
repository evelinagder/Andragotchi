package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.os.UserManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                String difficultyChoice="easy";
                UsersManager.setUserDifficulty(user,difficultyChoice);
                Intent intent= new Intent(DifficultyActivity.this,PetChoiceActivity.class);
               startActivity(intent);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String difficultyChoice="medium";
                UsersManager.setUserDifficulty(user,difficultyChoice);
                Intent intent= new Intent(DifficultyActivity.this,PetChoiceActivity.class);
                startActivity(intent);

            }
        });
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String difficultyChoice = "hard";
                UsersManager.setUserDifficulty(user,difficultyChoice);
                Intent intent = new Intent(DifficultyActivity.this, PetChoiceActivity.class);
                startActivity(intent);
            }
        });
    }
}
