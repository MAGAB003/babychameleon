package com.example.babychameleon;

public class Subscription {
   private String subscriptionID;
    private String name;
    private String description;
    private Integer imgID;
    private AgeGroup ageGroup;
    private String theme;

    public Subscription(String name, String description, Integer imgID, AgeGroup ageGroup, String theme){
    this.name=name;
    this.description=description;
    this.imgID=imgID;
    this.ageGroup=ageGroup;
    this.theme=theme;
    }

    public String getSubscriptionID() {
        return subscriptionID;
    }

    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getImgID() {
        return imgID;
    }

    public void setImgID(Integer imgID) {
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
