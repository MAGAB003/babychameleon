package com.example.babychameleon;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthdate;
    @Column(name = "Wears_Dress")
    private boolean wearsDress;
    @Column(name = "Favorite_Color")
    private String favoriteColor;
    @ManyToOne(fetch = FetchType.LAZY) // This means that the relationship won't be loaded right away, but only when and if actually needed.
    @JoinColumn(name = "ParentID")
    private Customer parent;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SubscriptionID")
    private Subscription subscription;

    public Child() {
    }

    public Child(Subscription subscription) {
        this.subscription = subscription;
    }

    public Child(String name, LocalDate date, boolean wearsDress, String favoriteColor) {
        this.name = name;
        this.birthdate = date;
        this.wearsDress = wearsDress;
        this.favoriteColor = favoriteColor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isWearsDress() {
        return wearsDress;
    }

    public void setWearsDress(boolean wearsDress) {
        this.wearsDress = wearsDress;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public Customer getParent() {
        return parent;
    }

    public void setParent(Customer parent) {
        this.parent = parent;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }
}
