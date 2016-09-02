package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.players.UsersManager;

public class LoginActivity extends AppCompatActivity {
    private static final int REQUEST_REG_USER = 10;
    Button login;
    Button register;
    EditText username;
    EditText password;

    // E if user exists- intent to homepage

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
                if (usernameString.isEmpty()) {
                    username.setError("Username is compulsory");
                    username.requestFocus();
                    return;
                }
                if (passwordString.length() == 0) {
                    password.setError("Password is compulsory");
                    password.requestFocus();
                    return;
                }
                if (!UsersManager.getInstance(LoginActivity.this).validalteLogin(usernameString, passwordString)) {
                    username.setError("Invalid credentials");
                    username.setText("");
                    password.setText("");
                    username.requestFocus();
                    return;
                }

//                if(UsersManager.getInstance(LoginActivity.this).existsUser(usernameString) && UsersManager.getInstance(LoginActivity.this).getUser(usernameString).getP{
//                    Intent intent =new Intent(LoginActivity.this, HomeActivity.class);
//                    intent.putExtra("loggedUser", UsersManager.getInstance(LoginActivity.this).getUser(usernameString));
//                    //Send user object in next Activity;" loggedUser" to HomeActivity if USER HAS LOGGED ONCE AND CHOSE PET?DOFF
//                    startActivity(intent);
//               }

                Intent intent = new Intent(LoginActivity.this, DifficultyActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(LoginActivity.this).getUser(usernameString));

                //Send user object in next Activity;" loggedUser"
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
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if(requestCode == REQUEST_REG_USER){
                if(resultCode == RegisterActivity.RESULT_REG_SUCCESSFUL){
                    String user = data.getStringExtra("username");
                    String pass = data.getStringExtra("password");
                    username.setText(user);
                    password.setText(pass);
                }
            }
        }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
