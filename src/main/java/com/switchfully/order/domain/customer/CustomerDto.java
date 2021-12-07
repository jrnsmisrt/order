package com.switchfully.order.domain.customer;

import java.util.UUID;

public class CustomerDto {
    private UUID customerId;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String address;
    private String phoneNumber;

    public UUID getCustomerId() {
        return this.customerId;
    }
    public CustomerDto setCustomerId(UUID id){
        this.customerId=id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CustomerDto changeFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CustomerDto changeLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public CustomerDto changeEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerDto changeAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public CustomerDto changePhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return "Customer: \n" +
                firstName + lastName + "\n" +
                "E-mail address: " + emailAddress + "\n" +
                "Address: " + address + "\n" +
                "PhoneNumber: " + phoneNumber;
    }


}
