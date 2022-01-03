package com.switchfully.order.domain.user;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity
@Table(name="user_account")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="user_level")
    private UserLevel userLevel;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="email_address")
    private String emailAddress;
    @Column(name="address")
    private String address;

    public User(String firstName, String lastName, String emailAddress, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.userLevel = UserLevel.CUSTOMER;
    }
    public User(){

    }

    public void changeUserLevel(UserLevel userLevel) {
        this.userLevel = userLevel;
    }

    public UserLevel showUserLevel() {
        return this.userLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void changeEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public void changeAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "[ [User] \n" +
                "UserLevel: " + userLevel + "\n" +
                firstName + lastName + "\n" +
                "E-mail address: " + emailAddress + "\n" +
                "Address: " + address + "\n" +
                "PhoneNumber: " + phoneNumber + " ]";
    }
}
