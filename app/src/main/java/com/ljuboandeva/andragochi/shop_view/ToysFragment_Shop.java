package com.ljuboandeva.andragochi.shop_view;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.shop.Shop;
import com.ljuboandeva.andragochi.model.shop.Toy;
import java.util.ArrayList;

public class ToysFragment_Shop extends Fragment {

    private View view;
    private String title;
    private static RecyclerView recyclerView;

    public ToysFragment_Shop() { }

    public ToysFragment_Shop(String title) { this.title = title; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop, container, false);
        setRecyclerView();
        return view;
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Toy> arrayList = Shop.getInstance().getToys();
        RecyclerView_Adapter_Toys adapter = new RecyclerView_Adapter_Toys(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);
    }
}
