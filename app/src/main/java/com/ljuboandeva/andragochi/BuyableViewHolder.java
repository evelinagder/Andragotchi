package com.ljuboandeva.andragochi;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ljubo on 9/16/2016.
 */

public class BuyableViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    TextView bonus;
    TextView bonusType;
    TextView count;
    CardView card;

    BuyableViewHolder(View view) {
        super(view);
        this.title = (TextView) view.findViewById(R.id.item_title);
        this.bonus = (TextView) view.findViewById(R.id.item_bonus);
        this.count = (TextView) view.findViewById(R.id.item_count);
        this.bonusType = (TextView) view.findViewById(R.id.item_bonus_type);
        this.card= (CardView)view.findViewById(R.id.cardView_inventory);
    }

}
