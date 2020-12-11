package com.example.babychameleon;
import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(name="CUSTOMERNUMBER")
    private int customerNumber;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;
    @Column(name="Email")
    private String email;
    @Column(name="Street_Address")
    private String streetAddress;
    @Column(name="Postal_Code")
    private int postalCode;
    private String city;
    @Column(name="CREDITCARDNUMBER")
    private int creditcardNumber;
    @Column(name="CARDEXPIRATIONDATE")
    private String cardExpirationDate;
    @Column(name="CVVCODE")
    private int cvvCode;


    public Customer(String firstName, String lastName, String email, String streetAddress, int postalCode,String city){
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.streetAddress=streetAddress;
    this.postalCode= postalCode;
    this.city=city;
    }

    public Customer(String firstName, String lastName, String customerEmail, String customerStreetAddress, int postalCode,String city, int creditcardNumber, String cardExpirationDate, int cvvCode){
    this(firstName,lastName,customerEmail, customerStreetAddress,postalCode,city);
    this.creditcardNumber=creditcardNumber;
    this.cardExpirationDate=cardExpirationDate;
    this.cvvCode=cvvCode;
    }

    private AtomicInteger idCounter=new AtomicInteger();

    private int createCustomerNumber() {
        return idCounter.incrementAndGet();
    }


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
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

    public void setLastName(String customerLastName) {
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

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCreditcardNumber() {
        return creditcardNumber;
    }

    public void setCreditcardNumber(int creditcardNumber) {
        this.creditcardNumber = creditcardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

}
