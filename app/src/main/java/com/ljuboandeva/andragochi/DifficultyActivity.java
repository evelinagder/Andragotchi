package com.ljuboandeva.andragochi;

import android.content.Intent;
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

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String difficultyChoice=null;
                switch (view.getId()){
                    case R.id.button_easy:
                        difficultyChoice="easy";
                        break;
                    case R.id.button_medium:
                        difficultyChoice="medium";
                        break;
                    case R.id.button_hard:
                        difficultyChoice="hard";
                        break;
                }
                UsersManager.getInstance(DifficultyActivity.this).setUserDifficulty(DifficultyActivity.this,user,difficultyChoice);
                Intent intent= new Intent(DifficultyActivity.this,PetChoiceActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(DifficultyActivity.this).getUser(user.getUsername()));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        };

        easy.setOnClickListener(onClickListener);
        medium.setOnClickListener(onClickListener);
        hard.setOnClickListener(onClickListener);
    }
}
