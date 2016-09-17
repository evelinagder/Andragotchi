package com.ljuboandeva.andragochi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;


import com.ljuboandeva.andragochi.takingCare.CareFragment;

public class CareActivity extends MusicActivity {

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

//        FragmentManager fragmentManager= getSupportFragmentManager();
//        FragmentTransaction transaction= fragmentManager.beginTransaction();
//        Fragment careFragment= new CareFragment();
//        transaction.add(R.id.activity_care, careFragment,"FRAGMENT");
//        transaction.commit();
//        final String type=getIntent().getExtras().get("type").toString();
//        ((CareFragment) careFragment).refreshList(type);


}
