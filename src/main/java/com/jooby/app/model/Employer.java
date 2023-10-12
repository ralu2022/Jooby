package com.jooby.app.model;
import lombok.Data;


@Data
public class Employer {

    private int employerID;
    private String employerName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String domain;
    private String country;

    public Employer(int employerID, String employerName, String addressLine1, String addressLine2, String city, String domain, String country) {
        this.employerID = employerID;
        this.employerName = employerName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.domain = domain;
        this.country = country;
    }

    public Employer(int employerID, String employerName) {
        this.employerID = employerID;
        this.employerName = employerName;
    }
}
