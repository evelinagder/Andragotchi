package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExitActivity extends AppCompatActivity {
    Button yesB;
    Button noB;
    boolean continueMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        continueMusic=true;
        setContentView(R.layout.activity_exit);
        yesB= (Button)findViewById(R.id.button_yes);
        noB=(Button)findViewById(R.id.button_No);

        yesB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }
    public void onPause()
    {
        super.onPause();
        if(!continueMusic)
            MusicManager.pause();
    }
    public void onResume()
    {
        super.onResume();

        continueMusic=false;
        MusicManager.start(this,R.raw.music);
    }


}
