package com.ljuboandeva.andragochi.shop_view;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.shop.Medicine;
import com.ljuboandeva.andragochi.model.shop.Shop;

import java.util.ArrayList;

public class MedsFragment_Shop extends Fragment {
    private View view;

    private String title;//String for tab title

    private static RecyclerView recyclerView;

    public MedsFragment_Shop() {
    }

    public MedsFragment_Shop(String title) {
        this.title = title;//Setting tab title
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);

        setRecyclerView();
        return view;

    }
    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items


        ArrayList<Medicine> arrayList = Shop.getInstance().getMedicines();



        RecyclerView_Adapter_Medicines adapter = new RecyclerView_Adapter_Medicines(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }
}
