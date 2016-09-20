package com.ljuboandeva.andragochi;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
        Log.e("MUSIC", continueMusic + " before resume");
        if (MusicManager.stopMusic == 0) {
            continueMusic = false;
            MusicManager.start(this, R.raw.music);
            Log.e("MUSIC", MusicManager.stopMusic + " music is starting");
        } else {
            Log.e("MUSIC", MusicManager.stopMusic + " music stopped");
        }
    }
}