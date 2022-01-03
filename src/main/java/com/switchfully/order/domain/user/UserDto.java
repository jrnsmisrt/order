package com.switchfully.order.domain.user;

import java.util.UUID;

public class UserDto {


    private String firstName;
    private String lastName;
    private long userId;
    private UserLevel userLevel;
    private String phoneNumber;
    private String emailAddress;
    private String address;

    public UserDto changeUserLevel(UserLevel userLevel){
        this.userLevel= userLevel;
        return this;
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
    public long getUserId(){
        return userId;
    }
    public UserDto setUserId(long userId){
        this.userId=userId;
        return this;
    }

    public UserDto changeFirstName(String firstName){
        this.firstName=firstName;
        return this;
    }
    public UserDto changeLastName(String lastName){
        this.lastName=lastName;
        return this;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public UserDto changeEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public UserDto changeAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UserDto changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
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
