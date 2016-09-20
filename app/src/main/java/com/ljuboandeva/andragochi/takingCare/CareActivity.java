package com.ljuboandeva.andragochi.takingCare;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.takingCare.CareFragment;

public class CareActivity extends AppCompatActivity {

    String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        type = getIntent().getExtras().get("type").toString();
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getFragments() == null || fragmentManager.getFragments().size() == 0) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            Fragment careFragment = new CareFragment();
            transaction.add(R.id.activity_care, careFragment, "FRAGMENT");
            Log.e("HHHH", "adding fragment");
            transaction.commit();
            Log.e("HHHH", "transaction fragment");

        }
    }
            public String getType(){

               return type;
    }



}
