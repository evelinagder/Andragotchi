package com.ljuboandeva.andragochi.model.shop;

/**
 * Created by Evelina on 8/26/2016.
 */
public class Medicine implements Buyable{
        public enum Type{ TABLET,NEEDLE};
        private Type type;
        private int price;
        private int count;

        public Medicine(Type type, int price){
                this.type=type;
                this.price=price;

        }

        public void setCount(int count) {
                this.count = count;
        }

        public int getPrice(){
                return this.price;
        }
        public Type getType(){
                return this.type;
        }
        @Override
        public void buy() {
        //TODO
        }
}
