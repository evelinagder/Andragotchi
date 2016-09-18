package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class OutChoiceActivity extends MusicActivity {

    Button button_park;
    Button button_sandbox;
    Button button_pool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_choice);

        button_park = (Button) findViewById(R.id.button_park);
        button_sandbox = (Button) findViewById(R.id.button_sandbox);
        button_pool = (Button) findViewById(R.id.button_pool);

        View.OnClickListener outChoiceListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String outChoice=null;
                switch (view.getId()){
                    case R.id.button_park:
                        outChoice="park";
                        break;
                    case R.id.button_sandbox:
                        outChoice="sandbox";
                        break;
                    case R.id.button_pool:
                        outChoice="pool";
                        break;
                }
                Intent intent= new Intent(OutChoiceActivity.this, PlaygroundActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(OutChoiceActivity.this).getUser(((User)getIntent().getExtras().get("loggedUser")).getUsername()));
                intent.putExtra("outChoice",outChoice);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        };

        button_pool.setOnClickListener(outChoiceListener);
        button_sandbox.setOnClickListener(outChoiceListener);
        button_park.setOnClickListener(outChoiceListener);
    }
}
