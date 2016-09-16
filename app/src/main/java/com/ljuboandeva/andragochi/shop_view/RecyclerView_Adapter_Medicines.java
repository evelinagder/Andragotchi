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
import com.ljuboandeva.andragochi.model.shop.Medicine;
import java.util.ArrayList;

public class RecyclerView_Adapter_Medicines extends RecyclerView.Adapter<MedsViewHolder> {
    private ArrayList<Medicine> arrayList;
    private Context context;
    private User user;

    public RecyclerView_Adapter_Medicines(Context context, ArrayList<Medicine> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.user=UsersManager.getInstance((Activity) context).getUser(((User) ((Activity) context).getIntent().getExtras().get("loggedUser")).getUsername());
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(MedsViewHolder holder, final int position) {

        final MedsViewHolder mainHolder = holder;
        final Medicine m= arrayList.get(position);
        mainHolder.title.setText(m.getType().toString());
        mainHolder.price.setText(Integer.toString(m.getPrice()));
        mainHolder.health.setText(Integer.toString(m.getHealth()));
        mainHolder.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Activity activity = ((Activity)v.getRootView().getContext());
                if(user.enoughMoney(m.getPrice())){
                    Toast.makeText(v.getRootView().getContext(),"Medicine bought",Toast.LENGTH_SHORT).show();
                    UsersManager.getInstance(activity).buyMedicine(activity,user,user.getMoney()-m.getPrice(),position);
                }
                else {
                    Toast.makeText(v.getRootView().getContext(),"Not enough money!",Toast.LENGTH_SHORT).show();
                }
            }
        });
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