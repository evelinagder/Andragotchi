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
import com.ljuboandeva.andragochi.model.shop.Toy;
import java.util.ArrayList;

public class RecyclerView_Adapter_Toys extends RecyclerView.Adapter<ToysViewHolder> {
    private ArrayList<Toy> arrayList;
    private Context context;
    private User user;

    public RecyclerView_Adapter_Toys(Context context, ArrayList<Toy> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.user= UsersManager.getInstance((Activity) context).getUser(((User) ((Activity) context).getIntent().getExtras().get("loggedUser")).getUsername());
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(ToysViewHolder holder, final int position) {

        final ToysViewHolder mainHolder = holder;
        final Toy t = arrayList.get(position);
        mainHolder.title.setText(t.getType().toString());
        mainHolder.price.setText(Integer.toString(t.getPrice()));
        mainHolder.fun.setText(Integer.toString(t.getFun()));
        mainHolder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = ((Activity)v.getRootView().getContext());
                if(user.enoughMoney(t.getPrice())){
                    Toast.makeText(v.getRootView().getContext(),"Toy bought",Toast.LENGTH_SHORT).show();
                    UsersManager.getInstance(activity).buyToy(activity,user,user.getMoney()-t.getPrice(),position);
                }
                else {
                    Toast.makeText(v.getRootView().getContext(),"Not enough money!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public ToysViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(R.layout.item_toy_shop, viewGroup, false);
        ToysViewHolder mainHolder = new ToysViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };
        return mainHolder;
    }
}