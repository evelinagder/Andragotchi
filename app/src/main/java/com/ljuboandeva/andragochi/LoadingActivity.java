package com.ljuboandeva.andragochi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class LoadingActivity extends MusicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        WebView wv = (WebView) findViewById(R.id.loading);
        wv.loadUrl("file:///assets/loading.gif");
    }
}
