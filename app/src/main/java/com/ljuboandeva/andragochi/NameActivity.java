package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.model.pet.Pet;
import com.ljuboandeva.andragochi.model.model.players.User;

public class NameActivity extends AppCompatActivity {
    Button confirmName;
    EditText typeName;
    //kak da predavame Usera suzdadden ot predishite activity?

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        confirmName=(Button)findViewById(R.id.Button_confirmName);
        typeName=(EditText)findViewById(R.id.editText_name);

       final String petName= typeName.getText().toString();


        confirmName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // User.pet.setName(petName);
                Intent intent= new Intent(NameActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
