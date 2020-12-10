package com.example.babychameleon;
import java.util.concurrent.atomic.AtomicInteger;

public class Customer {

    private String ID;
    private int customerNumber;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private String customerStreetAddress;
    private int postalCode;
    private String city;
    private int creditCardNumber;
    private String creditCardExpirationDate;
    private int cvvCode;
    private AtomicInteger idCounter=new AtomicInteger();

    public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerStreetAddress, int postalCode,String city){
    this.customerNumber=createCustomerNumber();
    this.customerFirstName=customerFirstName;
    this.customerLastName=customerLastName;
    this.customerEmail=customerEmail;
    this.customerStreetAddress=customerStreetAddress;
    this.postalCode= postalCode;
    this.city=city;
    }

    public Customer(String customerFirstName, String customerLastName, String customerEmail, String customerStreetAddress, int postalCode,String city, int creditCardNumber, String creditCardExpirationDate, int cvvCode){
    this(customerFirstName,customerLastName,customerEmail, customerStreetAddress,postalCode,city);
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

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerStreetAddress() {
        return customerStreetAddress;
    }

    public void setAddress(String customerStreetAddress) {
        this.customerStreetAddress = customerStreetAddress;
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
