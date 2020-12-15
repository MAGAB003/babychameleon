package com.example.babychameleon;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionCart {
    private List<Subscription> cart = new ArrayList<>();


    public SubscriptionCart() {
    }

    public SubscriptionCart(List<Subscription> sessioncart) {
        this.cart = cart;
    }

    public List<Subscription> getCart() {
        return cart;
    }

    public void setCart(List<Subscription> sessioncart) {
        this.cart = sessioncart;
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

    public void removeItem(Subscription subscription) {
        cart.remove(subscription);
    }
}
