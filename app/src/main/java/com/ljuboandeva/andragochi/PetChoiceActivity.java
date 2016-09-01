package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljuboandeva.andragochi.model.pet.PetManager;
import com.ljuboandeva.andragochi.model.players.User;

public class PetChoiceActivity extends AppCompatActivity {

    Button confirmPet;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_choice);

        confirmPet= (Button)findViewById(R.id.Button_confirmPet);
         user= (User) getIntent().getExtras().get("loggedUser");

        confirmPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //choosing pet?

               // PetManager.setUserPet(user, pet);
                Intent intеnt = new Intent(PetChoiceActivity.this, DifficultyActivity.class);
                    startActivity(intеnt);
            }
        });
    }
}
