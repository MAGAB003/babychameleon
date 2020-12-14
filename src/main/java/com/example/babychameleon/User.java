package com.example.babychameleon;

import javax.persistence.*;

@Entity
@Table (name="BABYCHAMELEONUSER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private Long customerID;
    private Long AdminID;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Long getCustomerID() { return customerID; }
    public void setCustomerID(Long customerID) { this.customerID = customerID; }
    public Long getAdminID() { return AdminID; }
    public void setAdminID(Long adminID) { AdminID = adminID; }
}