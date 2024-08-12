package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    @JsonProperty("method")
    private String method;

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("transaction_id")
    private String transaction_id;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }
}

