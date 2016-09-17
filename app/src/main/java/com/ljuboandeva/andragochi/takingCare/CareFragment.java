package com.ljuboandeva.andragochi.takingCare;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljuboandeva.andragochi.CareActivity;
import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Buyable;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CareFragment extends Fragment {
    CareActivity activity;
        User user;


    private RecyclerView itemsList;

    public CareFragment() {
        // Required empty public constructor
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity= (CareActivity) context;
    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String username=activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getString("currentUser", null);
        user= UsersManager.getInstance(activity).getUser(username);
        View root=inflater.inflate(R.layout.fragment_care, container, false);
        itemsList= (RecyclerView) root.findViewById(R.id.items_View);
        String type= activity.getType();
        itemsList.setAdapter(new CareRecyclerAdapter((CareActivity)getActivity(),user.getInventory(type)));
        itemsList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }


}
