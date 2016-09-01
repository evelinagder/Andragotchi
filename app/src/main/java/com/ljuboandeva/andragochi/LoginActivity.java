package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.model.players.UsersManager;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_REG_USER = 10;
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

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameString = username.getText().toString();
                String passwordString = password.getText().toString();
                if(usernameString.isEmpty()){
                    username.setError("Username is compulsory");
                    username.requestFocus();
                    return;
                }
                if(passwordString.length() == 0){
                    password.setError("Password is compulsory");
                    password.requestFocus();
                    return;
                }
                if(!UsersManager.getInstance(LoginActivity.this).validalteLogin(usernameString, passwordString)){
                    username.setError("Invalid credentials");
                    username.setText("");
                    password.setText("");
                    username.requestFocus();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                intent.putExtra("loggedUser", usernameString);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                username.setError(null);
                startActivityForResult(intent, REQUEST_REG_USER);
            }
        });
    }
}
