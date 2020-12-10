package com.example.babychameleon;
import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private int customerNumber;
    @Column(name="FirstName")
    private String firstName;
    @Column(name="LastName")
    private String lastName;
    @Column(name="Email")
    private String email;
    @Column(name="StreetAddress")
    private String streetAddress;
    private int postalCode;
    private String city;
    private int creditCardNumber;
    private String creditCardExpirationDate;
    private int cvvCode;
    private AtomicInteger idCounter=new AtomicInteger();

    public Customer(String firstName, String lastName, String email, String streetAddress, int postalCode,String city){
    this.customerNumber=createCustomerNumber();
    this.firstName=firstName;
    this.lastName=lastName;
    this.email=email;
    this.streetAddress=streetAddress;
    this.postalCode= postalCode;
    this.city=city;
    }

    public Customer(String firstName, String lastName, String customerEmail, String customerStreetAddress, int postalCode,String city, int creditCardNumber, String creditCardExpirationDate, int cvvCode){
    this(firstName,lastName,customerEmail, customerStreetAddress,postalCode,city);
    this.creditCardNumber=creditCardNumber;
    this.creditCardExpirationDate=creditCardExpirationDate;
    this.cvvCode=cvvCode;
    }

    private int createCustomerNumber() {
        return Integer.valueOf(idCounter.incrementAndGet());
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
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

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public int getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(int cvvCode) {
        this.cvvCode = cvvCode;
    }

}
