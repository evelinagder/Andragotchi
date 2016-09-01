package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.players.UsersManager;

public class RegisterActivity extends AppCompatActivity {
    EditText usernameR;
    EditText passR;
    EditText confirmPassR;
    EditText emailR;
    Button registerR;
    public static final int RESULT_REG_SUCCESSFUL = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usernameR = (EditText) findViewById(R.id.editText_usernameR);
        passR = (EditText) findViewById(R.id.editText_passwordR);
        confirmPassR = (EditText) findViewById(R.id.editText_confirmPassR);
        emailR = (EditText) findViewById(R.id.editText_email);
        registerR = (Button) findViewById(R.id.button_registerR);


        registerR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameU = usernameR.getText().toString();
                String passU = passR.getText().toString();
                String confirmU = confirmPassR.getText().toString();
                String emailU = emailR.getText().toString();
                String emailPattern = "^[A-Za-z][A-Za-z0-9]*([._-]?[A-Za-z0-9]+)@[A-Za-z].[A-Za-z]{0,3}?.[A-Za-z]{0,2}$";

                if (usernameU.isEmpty()) {
                    usernameR.setError("Username is compulsory");
                   usernameR.requestFocus();
                   return;
                }
                if (passU.length() == 0) {
                    passR.setError("Password is compulsory");
                    passR.requestFocus();
                    return;
                }
                if (confirmU.length() == 0) {
                    confirmPassR.setError("Second password is compulsory");
                    confirmPassR.requestFocus();
                    return;
                }
                if (emailU.isEmpty()) {
                    emailR.setError("Email is compulsory");
                    emailR.requestFocus();
                    return;
                }

                if (!(passU.equals(confirmU))){
                    passR.setError("Passwords mismatch");
                    passR.setText("");
                    confirmPassR.setText("");
                    confirmPassR.requestFocus();
                    return;
                }

                if (UsersManager.getInstance(RegisterActivity.this).existsUser(usernameU)) {
                    usernameR.setError("User already exists");
                    usernameR.setText("");
                    usernameR.requestFocus();
                    return;
                }

                UsersManager.getInstance(RegisterActivity.this).registerUser(RegisterActivity.this, usernameU, passU, emailU);


                Intent intent = new Intent();
                intent.putExtra("username", usernameR.getText().toString());
                intent.putExtra("password", passR.getText().toString());
                setResult(RESULT_REG_SUCCESSFUL, intent);
                finish();
            }
        });
    }

}








