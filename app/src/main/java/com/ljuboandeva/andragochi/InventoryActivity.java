package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;
import com.ljuboandeva.andragochi.model.shop.Buyable;
import com.ljuboandeva.andragochi.shop_view.RecyclerView_Adapter_Food;

import java.util.ArrayList;

public class InventoryActivity extends MusicActivity {
    public final static int SKULL_CAL=25;
    public final static int FLESH_CAL=15;
    public final static int BONE_CAL=5;
    public final static int TABLET_H=5;
    public final static int NEEDLE_H=40;
    public final static int BALL_F=10;
    public final static int GIRDLE_F=20;
    public final static int SHOVEL_F=30;

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
    public void itemSelected(String name,int position) {

            switch (name) {
                case "SKULL":
                case "FLESH":
                case "BONE":
                    if(getIntent().getStringExtra("from").equalsIgnoreCase("play")){
                        Toast.makeText(InventoryActivity.this, "Food is not allowed outside!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (pet.getFill() >= 100) {
                        Toast.makeText(InventoryActivity.this, "Your pet is not hungry!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (user.getFoods().get(position).getCount()<=0){
                        Toast.makeText(InventoryActivity.this, "Not enough... Please buy in shop!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    switch (name){
                        case "SKULL":
                            pet.setFill(pet.getFill() + SKULL_CAL); break;
                        case "FLESH":
                            pet.setFill(pet.getFill() + FLESH_CAL); break;
                        case "BONE":
                            pet.setFill(pet.getFill() + BONE_CAL);
                    }
                    user.removeFood(position);
                    break;
                case "TABLET":
                case "NEEDLE":
                    if(getIntent().getStringExtra("from").equalsIgnoreCase("play")){
                        Toast.makeText(InventoryActivity.this, "Medicine is not allowed outside!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (pet.getHealth() >= 100) {
                        Toast.makeText(InventoryActivity.this, "Your pet is not sick!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (user.getMeds().get(position-user.getFoods().size()-user.getToys().size()).getCount()<=0){
                        Toast.makeText(InventoryActivity.this, "Not enough... Please buy in shop!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    switch (name){
                        case "TABLET":
                            pet.setHealth(pet.getHealth() + TABLET_H);
                            break;
                        case "NEEDLE":
                            pet.setHealth(pet.getHealth() + NEEDLE_H);
                    }
                    user.removeMedicine(position-user.getFoods().size()-user.getToys().size());
                    break;
                case "BALL":
                case "GIRDLE":
                case "SHOVEL":
                    if(getIntent().getStringExtra("from").equalsIgnoreCase("home")){
                        Toast.makeText(InventoryActivity.this, "Toy is not allowed inside!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (pet.getHappiness() >= 100) {
                        Toast.makeText(InventoryActivity.this, "Your pet is happy!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (user.getToys().get(position-user.getFoods().size()).getCount()<=0){
                        Toast.makeText(InventoryActivity.this, "Not enough... Please buy in shop!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String outChoice=getIntent().getStringExtra("outChoice");
                    switch (name){
                        case "BALL":
                            if(outChoice.equalsIgnoreCase("park")) {
                                pet.setHappiness(pet.getHappiness() + BALL_F);
                            } else{
                                Toast.makeText(InventoryActivity.this, "I can't use this toy here!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            break;
                        case "GIRDLE":
                            if(outChoice.equalsIgnoreCase("pool")) {
                                pet.setHappiness(pet.getHappiness() + GIRDLE_F);
                            } else{
                                Toast.makeText(InventoryActivity.this, "I can't use this toy here!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            break;
                        case "SHOVEL":
                            if(outChoice.equalsIgnoreCase("sandbox")) {
                                pet.setHappiness(pet.getHappiness() + SHOVEL_F);
                            } else{
                                Toast.makeText(InventoryActivity.this, "I can't use this toy here!", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            break;
                    }
                    user.removeToy(position-user.getFoods().size());
                    break;
            }
            if(pet.getHealth()>100)pet.setHealth(100);
            if(pet.getHappiness()>100)pet.setHappiness(100);
            if(pet.getFill()>100)pet.setFill(100);
            UsersManager.getInstance(InventoryActivity.this).setUserPet(InventoryActivity.this, user, pet);
            Intent intent;
            if(getIntent().getStringExtra("from").equalsIgnoreCase("home")) {
                intent = new Intent(InventoryActivity.this, HomeActivity.class);
            }
            else{
                intent = new Intent(InventoryActivity.this, PlaygroundActivity.class);
                intent.putExtra("outChoice",getIntent().getStringExtra("outChoice"));
            }
            intent.putExtra("loggedUser", user);
            startActivity(intent);
    }
}
