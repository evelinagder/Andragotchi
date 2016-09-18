package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljuboandeva.andragochi.model.players.User;

public class DieActivity extends MusicActivity {
    Button restartB;
    Button exitB;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_die);
        restartB= (Button)findViewById(R.id.B_restart);
        exitB=(Button)findViewById(R.id.B_exit);
        user=(User) getIntent().getExtras().get("loggedUser");
        restartB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(DieActivity.this, PetChoiceActivity.class);
                intent. putExtra("loggedUser",user);
                startActivity(intent);

            }
        });
        exitB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
    }
}
