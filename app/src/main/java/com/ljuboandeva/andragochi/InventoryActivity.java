package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Buyable;
import com.ljuboandeva.andragochi.shop_view.RecyclerView_Adapter_Food;

import java.util.ArrayList;

public class InventoryActivity extends MusicActivity {
    public final static int SKULL_CAL=15;
    public final static int FLESH_CAL=10;
    public final static int BONE_CAL=5;
    public final static int TABLET_H=15;
    public final static int NEEDLE_H=30;



    private User user;
    private static RecyclerView recyclerView;
    ArrayList<Buyable> arrayList;
    Pet pet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        user = (User) getIntent().getExtras().get("loggedUser");
        arrayList = new ArrayList<>();
        pet= user.getPet();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_inventory);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(InventoryActivity.this));
        arrayList.addAll(user.getFoods());
        arrayList.addAll(user.getToys());
        arrayList.addAll(user.getMeds());
        RecyclerView_Adapter_Inventory adapter = new RecyclerView_Adapter_Inventory(InventoryActivity.this, arrayList);
        recyclerView.setAdapter(adapter);

    }
    public void itemSelected(String name){
        switch(name){
            case "SKULL":
                pet.setFill(pet.getFill()+SKULL_CAL);

                break;
            case "FLESH":
                pet.setFill(pet.getFill()+FLESH_CAL);
                break;
            case "BONE":
                pet.setFill(pet.getFill()+BONE_CAL);
                break;
            case "TABLET":
                pet.setHealth(pet.getHealth()+TABLET_H);
                break;
            case "NEEDLE":
                pet.setHealth(pet.getHealth()+NEEDLE_H);
                break;
        }
        UsersManager.getInstance(InventoryActivity.this).setUserPet(InventoryActivity.this,user,pet);
        Log.e("USER",user.getUsername()+" "+pet.getName());
        Intent intent = new Intent(InventoryActivity.this,HomeActivity.class);
        intent.putExtra("loggedUser",user);
        startActivity(intent);

    }

}
