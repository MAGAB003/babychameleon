package com.example.babychameleon;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionCart {

    protected List<Subscription> cart = new ArrayList<>();

    public SubscriptionCart() {
    }

    public SubscriptionCart(List<Subscription> cart) {
        this.cart = this.cart;
    }

    public List<Subscription> getCart() {
        return cart;
    }

    public void setCart(List<Subscription> cart) {
        this.cart = cart;
    }

    public int calculateSum(){
        int sum = 0;
        for (Subscription subscription : cart) {
            sum+=subscription.getPrice();
        }
        return sum;
    }

    public void addToCart(Subscription subscription){
        if (cart==null){
            cart = new ArrayList<>();
        }cart.add(subscription);
    }

    public void removeItem(int id) {
        cart.remove(id);
    }
}
