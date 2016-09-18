package com.ljuboandeva.andragochi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class SettingsActivity extends MusicActivity {

    Button button_logout;
    Button changeName;
    EditText nameET;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        user=(User) getIntent().getExtras().get("loggedUser");
        changeName = (Button) findViewById(R.id.button_changeName);
        nameET = (EditText) findViewById(R.id.name_settings);
        button_logout = (Button) findViewById(R.id.button_logout);

        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newName=nameET.getText().toString();
                if(newName.isEmpty()){
                    nameET.setError("Pet name is empty!");
                    nameET.requestFocus();
                    return;
                }
                Pet temp = user.getPet();
                temp.setName(newName);
                UsersManager.getInstance(SettingsActivity.this).setUserPet(SettingsActivity.this,user, temp);
                Toast.makeText(SettingsActivity.this,"Name changed",Toast.LENGTH_LONG).show();
            }
        });

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = SettingsActivity.this.getSharedPreferences("Andragochi", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("logged_in", false);
                editor.commit();
                Toast.makeText(SettingsActivity.this,"Logged out",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(SettingsActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(SettingsActivity.this,HomeActivity.class);
        intent.putExtra("loggedUser", user);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
