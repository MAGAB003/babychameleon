package com.example.babychameleon;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    protected List<Child> cartItems = new ArrayList<>();

    public Cart() {
    }

    public Cart(List<Subscription> cart) {
        this.cartItems = this.cartItems;
    }

    public List<Child> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Child> cartItems) {
        this.cartItems = cartItems;
    }

    public int calculateSum(){
        int sum = 0;
        for (Child child : cartItems) {
            sum+=child.getSubscription().getPrice();
        }
        return sum;
    }

    public void addToCart(Child child){
        if (cartItems ==null){
            cartItems = new ArrayList<>();
        }
        cartItems.add(child);
    }

    public void removeItem(int id) {
        cartItems.remove(id);
    }
}
