package com.chandra.MUIBackendAPI.models;

import java.time.LocalDate;

public class EmployeeFormModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate dateOfJoining;
    private String address;
    private int country;

    public EmployeeFormModel(String firstName, String lastName, String email, String phone, LocalDate dateOfJoining, String address, int country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.dateOfJoining = dateOfJoining;
        this.address = address;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeFormModel(int country) {

        this.country = country;
    }

    @Override
    public String toString() {
        return "EmployeeFormModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfJoining=" + dateOfJoining +
                ", address='" + address + '\'' +
                '}';
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}

