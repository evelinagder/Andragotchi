package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.model.players.UsersManager;

public class LoginActivity extends AppCompatActivity {
    Button login;
    Button register;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.button_loginL);
        register = (Button) findViewById(R.id.button_registerL);
        username = (EditText) findViewById(R.id.textView_usernameL);
        password = (EditText) findViewById(R.id.textView_passwordL);
        final String usernameText = username.getText().toString();
        final String passwordText = password.getText().toString();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UsersManager.getInstance().validateLogin(usernameText, passwordText)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    register.setError("Invalid Login.");
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO class 33
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
