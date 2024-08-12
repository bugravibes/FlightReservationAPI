package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT_DETAILS")
public class PaymentDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "METHOD", nullable = false)
    private String method;

    @Column(name = "AMOUNT", nullable = false)
    private Double amount;

    @Column(name = "CURRENCY", nullable = false)
    private String currency;

    @Column(name = "CARD_NUMBER", nullable = false)
    private String cardNumber;

    @Column(name = "EXPIRY_DATE", nullable = false)
    private String expiryDate;

    @Column(name = "CVV", nullable = false)
    private String cvv;

    @Column(name = "CARDHOLDER_NAME", nullable = false)
    private String cardholderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }
}
