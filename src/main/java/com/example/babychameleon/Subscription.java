package com.example.babychameleon;

public class Subscription {
    private String ID;
    private String subscriptionName;
    private String subscriptionDescription;
    private String imgID;
    private AgeGroup ageGroup;
    private String theme;

    public Subscription(String subscriptionName, String subscriptionDescription, String imgID, AgeGroup ageGroup, String theme){
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

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(AgeGroup ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}
