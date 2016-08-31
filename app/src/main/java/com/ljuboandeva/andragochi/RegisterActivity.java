package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewTreeObserver;
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
        final String emailPattern = "^[A-Za-z][A-Za-z0-9]*([._-]?[A-Za-z0-9]+)@[A-Za-z].[A-Za-z]{0,3}?.[A-Za-z]{0,2}$";


        final View activityRootView = findViewById(R.id.activtyRoot);
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                if(usernameU.equals("") || passU.equals("")|| confirmU.equals("")|| emailU.equals("")){
                    registerR.setEnabled(false);
                }
                if(!(confirmU.equals(passU))){
                    confirmPassR.setError("Passwords don`t match. Try again!");
                    registerR.setEnabled(false);
                }
                if (!(emailU.matches(emailPattern))) {
                    emailR.setError("Invalid e-mail address");
                    registerR.setEnabled(false);
                }

            }
        });

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
