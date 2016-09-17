package com.ljuboandeva.andragochi.shop_view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.ljuboandeva.andragochi.R;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Food;
import java.util.ArrayList;

public class RecyclerView_Adapter_Food extends RecyclerView.Adapter<FoodViewHolder> {
    private ArrayList<Food> arrayList;
    private Context context;
    private User user;

    public RecyclerView_Adapter_Food(Context context, ArrayList<Food> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.user=UsersManager.getInstance((Activity) context).getUser(((User) ((Activity) context).getIntent().getExtras().get("loggedUser")).getUsername());
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, final int position) {

        final FoodViewHolder mainHolder = holder;
        final Food f= arrayList.get(position);
        mainHolder.title.setText(f.getType().toString());
        mainHolder.price.setText(Integer.toString(f.getPrice()));
        mainHolder.calories.setText(Integer.toString(f.getCalories()));
        mainHolder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = ((Activity)v.getRootView().getContext());
                if(user.enoughMoney(f.getPrice())){
                    Toast.makeText(v.getRootView().getContext(),"Food bought",Toast.LENGTH_SHORT).show();
                    UsersManager.getInstance(activity).buyFood(activity,user,user.getMoney()-f.getPrice(),position);
                }
                else {
                    Toast.makeText(v.getRootView().getContext(),"Not enough money!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_food_shop, viewGroup, false);
        FoodViewHolder mainHolder = new FoodViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return mainHolder;
    }
}