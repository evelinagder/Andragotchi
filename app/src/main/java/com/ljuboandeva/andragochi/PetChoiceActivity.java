package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PetChoiceActivity extends AppCompatActivity {

    Button confirmPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_choice);

        confirmPet= (Button)findViewById(R.id.Button_confirmPet);

        confirmPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intеnt= new Intent(PetChoiceActivity.this, NameActivity.class)м
                    startActivity(intеnt);
            }
        });
    }
}
