package com.ljuboandeva.andragochi.model.shop_view;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ljuboandeva.andragochi.R;

public abstract class FoodViewHolder extends RecyclerView.ViewHolder {


    public TextView title;
    public TextView price;
    public TextView calories;
    public Button buy;


    public FoodViewHolder(View view) {
        super(view);

        this.buy = (Button) view.findViewById(R.id.buy_button_food);
        this.title = (TextView) view.findViewById(R.id.food_title);
        this.price = (TextView) view.findViewById(R.id.food_price);
        this.calories = (TextView) view.findViewById(R.id.food_calories);

    }


}