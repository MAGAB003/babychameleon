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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ParentID")
    private Customer parent;

    public Child() {
    }

    public Child(Long id, String name, LocalDate date, boolean wearsDress, String favoriteColor) {
        this.id = id;
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

}
