package com.switchfully.order.domain.customer;

public class Customer {
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String address;
    private String phoneNumber;

    public Customer(String firstName, String lastName, String emailAdress, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void changeFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void changeLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void changeEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
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
        return "Customer: \n" +
                firstName + lastName + "\n" +
                "E-mail address: " + emailAdress+"\n"+
                "Address: " + address + "\n" +
                "PhoneNumber: " + phoneNumber;
    }
}
