package com.ljuboandeva.andragochi;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ljuboandeva.andragochi.fragments_inventory.*;


public class InventoryActivity extends AppCompatActivity implements FoodFragment.OnFragmentInteractionListener,
        ToysFragment.OnFragmentInteractionListener,MedsFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_inventory);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_inventory);
        tabLayout.addTab(tabLayout.newTab().setText("FOOD"));
        tabLayout.addTab(tabLayout.newTab().setText("TOYS"));
        tabLayout.addTab(tabLayout.newTab().setText("MEDS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager_inventory);
        final InventoryPagerAdapter adapter = new InventoryPagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
