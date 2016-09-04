package com.ljuboandeva.andragochi;

/**
 * Created by ljubo on 9/1/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ljuboandeva.andragochi.fragments_inventory.FoodFragment;
import com.ljuboandeva.andragochi.fragments_inventory.MedsFragment;
import com.ljuboandeva.andragochi.fragments_inventory.ToysFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FoodFragment foodFR = new FoodFragment();
                return foodFR;
            case 1:
                ToysFragment toysFR = new ToysFragment();
                return toysFR;
            case 2:
                MedsFragment medsFR = new MedsFragment();
                return medsFR;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}