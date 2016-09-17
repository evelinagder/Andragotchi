package com.ljuboandeva.andragochi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;
import android.widget.Toast;
=======
>>>>>>> 5dd0c43a9b4d5bb383c22986750411da98f10254

import com.ljuboandeva.andragochi.takingCare.CareFragment;

public class CareActivity extends AppCompatActivity {
<<<<<<< HEAD
    String type;
=======

>>>>>>> 5dd0c43a9b4d5bb383c22986750411da98f10254
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
<<<<<<< HEAD
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


=======
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        Fragment careFragment= new CareFragment();
        transaction.add(R.id.activity_care, careFragment,"FRAGMENT");
        transaction.commit();
        final String type=getIntent().getExtras().get("type").toString();
        ((CareFragment) careFragment).refreshList(type);

    }
>>>>>>> 5dd0c43a9b4d5bb383c22986750411da98f10254
}
