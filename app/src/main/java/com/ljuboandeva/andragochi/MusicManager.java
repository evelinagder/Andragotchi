package com.ljuboandeva.andragochi;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;

/**
 * Created by Evelina on 9/19/2016.
 */

public class MusicManager {
    private static final String TAG = "MusicManager";
    static MediaPlayer mp;
    private static int currentMusic = -1;
    public static int stopMusic =0;



    public static void start(Context context, int music) {
        start(context, music, false);
    }

    public static void start(Context context, int music, boolean force) {
        if (!force && currentMusic > -1) {
// already playing some music and not forced to change
            return;
        }
        if (currentMusic == music) {
// already playing this music
            return;
        }
        currentMusic = music;
        Log.d(TAG, "Current music is now [" + currentMusic + "]");
        if (mp != null) {
            if (!mp.isPlaying()) {
                mp.start();
            }
        } else {
            mp = MediaPlayer.create(context, R.raw.music); //Ur BackGround Music
        }

        if (mp == null) {
            Log.e(TAG, "player was not created successfully");
        } else {
            try {
                mp.setLooping(true);
                mp.start();
            } catch (Exception e) {
                Log.e(TAG, e.getMessage(), e);
            }
        }
    }

    public static void pause() {
        if (mp != null) {
            if (mp.isPlaying()) {
                mp.pause();
            }
        }

        currentMusic = -1;
        Log.d(TAG, "Current music is now [" + currentMusic + "]");
    }

    public static void release() {
        Log.d(TAG, "Releasing media players");
        try {
            if (mp != null) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                mp.release();
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        currentMusic = -1;
        Log.d(TAG, "Current music is now [" + currentMusic + "]");
    }
}
