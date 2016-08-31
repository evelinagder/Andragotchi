package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.model.players.User;
import com.ljuboandeva.andragochi.model.model.players.UsersManager;

public class RegisterActivity extends AppCompatActivity {
    EditText usernameR;
    EditText passR;
    EditText confirmPassR;
    EditText emailR;
    Button registerR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameR= (EditText)findViewById(R.id.editText_usernameR);
        passR=(EditText)findViewById(R.id.editText_passwordR);
        confirmPassR=(EditText)findViewById(R.id.editText_confirmPassR);
        emailR=(EditText)findViewById(R.id.editText_email);
        registerR=(Button)findViewById(R.id.button_registerR);

        final String usernameU=usernameR.getText().toString();
        final String passU = passR.getText().toString();
        final String confirmU= confirmPassR.getText().toString();
        final String emailU = emailR.getText().toString();

        if(!confirmU.equals(passU)){
            confirmPassR.setError("Passwords don`t match. Try again!");
        }
        registerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsersManager.getInstance().registerUser(new User(usernameU,passU,emailU));
                Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
