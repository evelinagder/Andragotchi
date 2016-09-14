package com.ljuboandeva.andragochi.shop_view;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ljuboandeva.andragochi.R;


public abstract class MedsViewHolder extends RecyclerView.ViewHolder {


    public TextView title;
    public TextView price;
    public TextView health;
    public Button buy;


    public MedsViewHolder(View view) {
        super(view);

        this.buy = (Button) view.findViewById(R.id.buy_button_medicine);
        this.title = (TextView) view.findViewById(R.id.medicine_title);
        this.price = (TextView) view.findViewById(R.id.medicine_price);
        this.health = (TextView) view.findViewById(R.id.medicine_health);

    }


}