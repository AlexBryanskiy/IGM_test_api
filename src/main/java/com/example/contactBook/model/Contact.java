package com.example.contactBook.model;

import java.util.UUID;

public class Contact {

    private UUID id = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String fullName;
    private String phoneNumber;
    private String cellPhoneNumber;
    private String address;

    public Contact() {
        this.id = UUID.randomUUID();
    };

    public Contact(String firstName, String lastName, String fullName, String phoneNumber, String cellPhoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.cellPhoneNumber = cellPhoneNumber;
        this.address = address;
    }

    public UUID getId() {
        return id;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cellPhoneNumber='" + cellPhoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

//    private static void incrementId() {
//        id++;
//    }
}
