package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class PetChoiceActivity extends MusicActivity {

    Button confirmPet;
    EditText namePet;
    ImageButton right;
    ImageButton left;
    String petType;
    ImageView petPic;
    int counter=0;

    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_choice);

        namePet = (EditText) findViewById(R.id.editText_NamePet);
        confirmPet = (Button) findViewById(R.id.Button_confirmPet);
        right = (ImageButton) findViewById(R.id.button_right);
        left = (ImageButton) findViewById(R.id.button_left);
        petPic = (ImageView) findViewById(R.id.pet_picture);
        user = (User) getIntent().getExtras().get("loggedUser");
        changePet(counter);

        right.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (counter < 2) {
                  changePet(++counter);

                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    changePet(--counter);
                }
            }
        });


        confirmPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePet(counter);
                String petName=namePet.getText().toString();
                if(petName.isEmpty()){
                    namePet.setError("Pet name is empty!");
                    namePet.requestFocus();
                    return;
                }
                confirmPet.setError(null);
                Pet userPet = new Pet(petType, petName);
                UsersManager.getInstance(PetChoiceActivity.this).setUserPet(PetChoiceActivity.this,user,userPet);
                Intent intent = new Intent(PetChoiceActivity.this, HomeActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PetChoiceActivity.this).getUser(user.getUsername()));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
        private void changePet(int counter){
        switch(counter){
            case 0:
                petType="Drago";
                petPic.setImageResource(R.drawable.drago_home);break;
            case 1:
                petType="Rhina";
                petPic.setImageResource(R.drawable.rhina_home);break;
            case 2:
                petType="Rex";
                petPic.setImageResource(R.drawable.rex_home);break;
        }
    }
}
