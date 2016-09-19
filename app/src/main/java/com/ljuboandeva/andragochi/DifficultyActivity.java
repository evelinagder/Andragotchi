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
    boolean continueMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        continueMusic=true;
        setContentView(R.layout.activity_dfficulty);
        easy=(Button)findViewById(R.id.button_easy);
        medium= (Button)findViewById(R.id.button_medium);
        hard=(Button)findViewById(R.id.button_hard);
        user= (User) getIntent().getExtras().get("loggedUser");

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int difficultyChoice=0;
                switch (view.getId()){
                    case R.id.button_easy:
                        difficultyChoice=6;
                        break;
                    case R.id.button_medium:
                        difficultyChoice=5;
                        break;
                    case R.id.button_hard:
                        difficultyChoice=4;
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
    public void onPause()
    {
        super.onPause();
        if(!continueMusic)
            MusicManager.pause();
    }
    public void onResume()
    {
        super.onResume();

        continueMusic=false;
        MusicManager.start(this,R.raw.music);
    }




}
