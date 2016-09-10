package com.ljuboandeva.andragochi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

public class PlaygroundActivity extends AppCompatActivity {

    String outChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_playground);
        outChoice = getIntent().getStringExtra("outChoice");
        switch (outChoice){
            case "park":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_park));
                break;
            case "pool":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_pool));
                break;
            case "sandbox":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_sandbox));
                break;
        }



    }
}
