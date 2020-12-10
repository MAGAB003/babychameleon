package com.example.babychameleon;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    @Column(name="Subscription_Name")
    private String subscriptionName;
    @Column(name="Subscription_Description")
    private String subscriptionDescription;
    private String imgID;
    @Column(name="Age_Group")
    private String ageGroup;
    private String theme;

    public Subscription(){
    }

    public Subscription(String subscriptionName, String subscriptionDescription, String imgID, String ageGroup, String theme){
    this.subscriptionName =subscriptionName;
    this.subscriptionDescription=subscriptionDescription;
    this.imgID=imgID;
    this.ageGroup=ageGroup;
    this.theme=theme;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getSubscriptionName() {
        return subscriptionName;
    }

    public void setSubscriptionName(String subscriptionName) {
        this.subscriptionName = subscriptionName;
    }

    public String getSubscriptionDescription() {
        return subscriptionDescription;
    }

    public void setSubscriptionDescription(String subscriptionDescription) {
        this.subscriptionDescription = subscriptionDescription;
    }

    public String getImgID() {
        return imgID;
    }

    public void setImgID(String imgID) {
        this.imgID = imgID;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
