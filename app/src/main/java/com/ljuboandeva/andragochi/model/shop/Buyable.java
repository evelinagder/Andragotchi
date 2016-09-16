package com.ljuboandeva.andragochi.model.shop;
import java.io.Serializable;

/**
 * Created by Evelina on 8/29/2016.
 */
public abstract class Buyable implements Serializable{

    public abstract int getCount();
    public abstract String getType();
    public abstract int getBonus();
    public abstract int getPrice();

}
