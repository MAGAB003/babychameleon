package com.example.babychameleon;

import javax.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    @Column(name = "Age_Group")
    private String ageGroup;
    private String theme;
    private int price;

    public Subscription() {
    }

    public Subscription(String name, String description, String img1, String img2, String img3, String img4, String ageGroup, String theme, int price) {
        this.name = name;
        this.description = description;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.ageGroup = ageGroup;
        this.theme = theme;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getSizeRange(String ageGroup) {
        String[] sizeRanges;
        switch (ageGroup) {
            case "NEWBORN":
                sizeRanges = new String[]{"50", "56", "62", "68", "74", "80", "86", "92"};
                break;
            case "BABY":
                sizeRanges = new String[]{"68", "74", "80", "86", "92", "98", "104"};
                break;
            case "KIDS":
                sizeRanges = new String[]{"92", "98/104", "110/116", "122/138", "134/140"};
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ageGroup);
        }
        return sizeRanges;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                ", img4='" + img4 + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", theme='" + theme + '\'' +
                ", price=" + price +
                '}';
    }
}
