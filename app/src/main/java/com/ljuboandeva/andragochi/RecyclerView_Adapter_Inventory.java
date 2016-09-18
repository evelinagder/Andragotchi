package com.ljuboandeva.andragochi;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Buyable;
import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.util.ArrayList;

/**
 * Created by ljubo on 9/16/2016.
 */
public class RecyclerView_Adapter_Inventory extends RecyclerView.Adapter<BuyableViewHolder> {
    private ArrayList<Buyable> arrayList;
    private InventoryActivity activity;
    private User user;

    public RecyclerView_Adapter_Inventory(InventoryActivity activity, ArrayList<Buyable> arrayList) {
        this.activity = activity;
        this.arrayList = arrayList;
        String username=activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getString("currentUser", null);
        Log.e("USER",username);
        this.user=UsersManager.getInstance(activity).getUser(username);
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(BuyableViewHolder holder, final int position) {
        final BuyableViewHolder mainHolder = holder;
         Buyable b = arrayList.get(position);
        mainHolder.title.setText(b.getType());
        mainHolder.bonus.setText(Integer.toString(b.getBonus()));
        if(b instanceof Food){mainHolder.bonusType.setText("Calories");}
        else if (b instanceof Toy){mainHolder.bonusType.setText("Fun");}
        else mainHolder.bonusType.setText("Health");

        mainHolder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            activity.itemSelected(arrayList.get(position).getType());
            }
        });
    }


    @Override
    public BuyableViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_inventory, viewGroup, false);
        BuyableViewHolder mainHolder = new BuyableViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return mainHolder;
    }
}