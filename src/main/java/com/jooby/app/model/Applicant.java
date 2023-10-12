package com.jooby.app.model;

import lombok.Data;


@Data
public class Applicant {

    private int applicantID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String state;
    private String city;
    private String personalIdentificationNumber;


    public Applicant(int applicantID, String firstName, String lastName, String phoneNumber, String emailAddress, String addressLine1, String addressLine2, String country, String state, String city, String personalIdentificationNumber) {
        this.applicantID = applicantID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.country = country;
        this.state = state;
        this.city = city;
        this.personalIdentificationNumber = personalIdentificationNumber;
    }
}
