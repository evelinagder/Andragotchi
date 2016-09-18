package com.ljuboandeva.andragochi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Buyable;
import com.ljuboandeva.andragochi.shop_view.RecyclerView_Adapter_Food;

import java.util.ArrayList;

public class InventoryActivity extends AppCompatActivity {

    private User user;
    private static RecyclerView recyclerView;
    ArrayList<Buyable> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        user = UsersManager.getInstance(InventoryActivity.this).getUser(((User) getIntent().getExtras().get("loggedUser")).getUsername());
        arrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_inventory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(InventoryActivity.this));
        arrayList.addAll(user.getFoods());
        arrayList.addAll(user.getToys());
        arrayList.addAll(user.getMeds());
        RecyclerView_Adapter_Inventory adapter = new RecyclerView_Adapter_Inventory(InventoryActivity.this, arrayList);
        recyclerView.setAdapter(adapter);
    }
}
