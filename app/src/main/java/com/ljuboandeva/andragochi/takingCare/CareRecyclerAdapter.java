package com.ljuboandeva.andragochi.takingCare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.ljuboandeva.andragochi.CareActivity;
import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Buyable;
import com.ljuboandeva.andragochi.model.shop.Food;
import com.ljuboandeva.andragochi.model.shop.Toy;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.view.PagerAdapter.POSITION_NONE;

/**
 * Created by Evelina on 9/17/2016.
 */

public class CareRecyclerAdapter extends RecyclerView.Adapter<CareRecyclerAdapter.ItemsVH> {

    private CareActivity activity;
    private List<Buyable> items;
    Buyable  item;
    User user;



    CareRecyclerAdapter(CareActivity activity, ArrayList<Buyable> items) {
        this.items = items;
        this.activity= activity;
        String username= activity.getSharedPreferences("Andragochi", Context.MODE_PRIVATE).getString("currentUser", null);
        user= UsersManager.getInstance(activity).getUser(username);
    }



    @Override
    public ItemsVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View row = inflater.inflate(R.layout.items_list_row, parent, false);
        row.findViewById(R.id.items_row_layout).setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ItemsVH(row);
    }

    @Override
    public void onBindViewHolder(ItemsVH holder, int position) {
        final ItemsVH mainHolder = holder;
        item= items.get(position);
        mainHolder.name.setText(item.getType());
        mainHolder.count.setText(Integer.toString(item.getCount()));
        mainHolder.calories.setText(Integer.toString(item.getBonus()));
        if(item instanceof Food){mainHolder.bonusType.setText("Calories");}
        else if (item instanceof Toy){mainHolder.bonusType.setText("Fun");}
        else mainHolder.bonusType.setText("Health");




        holder.use.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.decreaseCount();
              Pet pet= user.getPet();
                if(item instanceof Food){pet.setFill(pet.getFill()+ item.getBonus());}
                else if (item instanceof Toy){pet.setHappiness(pet.getHappiness()+item.getBonus());}
                else pet.setHealth(pet.getHealth()+item.getBonus());
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setNewItems(ArrayList<Buyable> newItems) {
        items = newItems;
    }

    class ItemsVH extends RecyclerView.ViewHolder{

        TextView name;
        TextView count;
        TextView calories;
        Button use;
        TextView bonusType;



        public ItemsVH(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textView_type);
            count = (TextView) itemView.findViewById(R.id.textView_count);
            calories = (TextView) itemView.findViewById(R.id.textView_calories);
           bonusType=(TextView) itemView.findViewById(R.id.bonus_TV);
            use = (Button) itemView.findViewById(R.id.B_use);

        }
    }

}

