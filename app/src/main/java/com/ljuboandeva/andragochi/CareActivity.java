package com.ljuboandeva.andragochi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ljuboandeva.andragochi.takingCare.CareFragment;

public class CareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        Fragment careFragment= new CareFragment();
        transaction.add(R.id.activity_care, careFragment,"FRAGMENT");
        transaction.commit();
        final String type=getIntent().getExtras().get("type").toString();
        ((CareFragment) careFragment).refreshList(type);

    }
}
