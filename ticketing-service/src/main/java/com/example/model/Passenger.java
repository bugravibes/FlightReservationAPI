package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Passenger {
    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("dob")
    private Date dob;

    @JsonProperty("passport_number")
    private String passportNumber;

    @JsonProperty("nationality")
    private String nationality;

    @JsonProperty("ticket_number")
    private String ticket_number;


    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number = ticket_number;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


}
