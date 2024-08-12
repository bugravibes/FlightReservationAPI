package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInfo{
    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
