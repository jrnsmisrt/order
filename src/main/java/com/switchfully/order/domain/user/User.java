package com.switchfully.order.domain.user;


import java.util.UUID;

public class User {

    private String firstName;
    private String lastName;
    private final UUID userId;
    private UserLevel userLevel;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    public User(String firstName, String lastName,String emailAddress, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId=UUID.randomUUID();
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.userLevel=UserLevel.CUSTOMER;
    }

    public void changeUserLevel(UserLevel userLevel){
        this.userLevel= userLevel;
    }

    public UserLevel showUserLevel(){
        return this.userLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeFirstName(String firstName){
        this.firstName=firstName;
    }
    public void changeLastName(String lastName){
        this.lastName=lastName;
    }
    public UUID getUserId(){
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
                "UserLevel: "+userLevel+"\n"+
                firstName + lastName + "\n" +
                "E-mail address: " + emailAddress + "\n" +
                "Address: " + address + "\n" +
                "PhoneNumber: " + phoneNumber+" ]";
    }
}
