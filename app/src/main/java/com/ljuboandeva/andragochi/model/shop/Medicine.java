package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Medicine extends Buyable {

        public enum Type {TABLET, NEEDLE}

        private Type type;
        private int price;
        private int count;
        private int health;

        public Medicine(Type type, int price, int health, int count) {
                this.type = type;
                this.price = price;
                this.count = count;
                this.health = health;
        }

        public String getType() { return this.type.toString(); }

        @Override
        public int getBonus() { return health; }

        public int getPrice() {
                return this.price;
        }

        public int getHealth() { return health; }

        public int getCount() { return count; }

        public void setCount(int count) {
                this.count = count;
        }

        public void increaseCount() { this.count += 1; }
        public void decreaseCount(){
                this.count--;
        }
}
