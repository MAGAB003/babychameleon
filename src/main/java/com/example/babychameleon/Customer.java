package com.example.babychameleon;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    private String email;
    @Column(name = "Street_Address")
    private String streetAddress;
    @Column(name = "Postal_Code")
    private String postalCode;
    private String city;
    private String country;
    @Column(name = "Name_On_Card")
    private String nameOnCard;
    @Column(name = "Credit_Card_Number")
    private String creditCardNumber;
    @Column(name = "Card_Expiration_Date")
    private String cardExpirationDate;
    @Column(name = "Cvv_Code")
    private String cvvCode;
    @OneToMany(mappedBy = "parent",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private List<Child> children = new ArrayList<>();

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, String streetAddress, String postalCode, String city, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
        nameOnCard = firstName + " " + lastName;
    }

    public Customer(String firstName, String lastName, String customerEmail, String customerStreetAddress, String postalCode, String city, String country, String creditcardNumber, String cardExpirationDate, String cvvCode) {
        this(firstName, lastName, customerEmail, customerStreetAddress, postalCode, city, country);
        this.creditCardNumber = creditcardNumber;
        this.cardExpirationDate = cardExpirationDate;
        this.cvvCode = cvvCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public String getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(String cvvCode) {
        this.cvvCode = cvvCode;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public void addChild(Child child) {
        child.setParent(this);
        children.add(child);
    }

    public void removeChild(Child child) {
        child.setParent(null);
        children.remove(child);
    }
}
