package com.ljuboandeva.andragochi.shop_view;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ljuboandeva.andragochi.R;


public abstract class ToysViewHolder extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView price;
    public TextView fun;
    public Button buy;


    public ToysViewHolder(View view) {
        super(view);

        this.buy = (Button) view.findViewById(R.id.buy_button_toy);
        this.title = (TextView) view.findViewById(R.id.toy_title);
        this.price = (TextView) view.findViewById(R.id.toy_price);
        this.fun = (TextView) view.findViewById(R.id.toy_fun);

    }


}