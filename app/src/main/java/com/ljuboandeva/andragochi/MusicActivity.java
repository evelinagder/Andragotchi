package com.ljuboandeva.andragochi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MusicActivity extends AppCompatActivity {
    boolean continueMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        continueMusic = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);
    }

    public void onPause() {
        super.onPause();
        if (!continueMusic)
            MusicManager.pause();
    }

    public void onResume() {
        super.onResume();

        continueMusic = false;
        MusicManager.start(this, R.raw.music);
    }
}