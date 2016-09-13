package com.ljuboandeva.andragochi.model.shop_view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.shop.Medicine;

import java.util.ArrayList;


public class RecyclerView_Adapter_Medicines extends RecyclerView.Adapter<MedsViewHolder> {
    private ArrayList<Medicine> arrayList;
    private Context context;


    public RecyclerView_Adapter_Medicines(Context context, ArrayList<Medicine> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(MedsViewHolder holder, int position) {

        final MedsViewHolder mainHolder = holder;
//        mainHolder.title.setText();
//        mainHolder.price.setText();

    }

    @Override
    public MedsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_medicine_shop, viewGroup, false);
        MedsViewHolder mainHolder = new MedsViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }


}