package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightTicketingRequest {

    @JsonProperty("ticketing_request")
    private TicketingRequest ticketingRequest;

    public TicketingRequest getTicketingRequest() {
        return ticketingRequest;
    }

    public void setTicketingRequest(TicketingRequest ticketingRequest) {
        this.ticketingRequest = ticketingRequest;
    }

    public static class TicketingRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_password")
        private String clientPassword;

        @JsonProperty("reservation_id")
        private String reservationId;

        @JsonProperty("payment_confirmation")
        private PaymentConfirmation paymentConfirmation;

        // Getters and Setters
        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
        }

        public String getClientPassword() {
            return clientPassword;
        }

        public void setClientPassword(String clientPassword) {
            this.clientPassword = clientPassword;
        }

        public String getReservationId() {
            return reservationId;
        }

        public void setReservationId(String reservationId) {
            this.reservationId = reservationId;
        }

        public PaymentConfirmation getPaymentConfirmation() {
            return paymentConfirmation;
        }

        public void setPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
            this.paymentConfirmation = paymentConfirmation;
        }
    }

    public static class PaymentConfirmation {
        @JsonProperty("transaction_id")
        private String transactionId;

        @JsonProperty("amount")
        private double amount;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("payment_method")
        private String paymentMethod;

        // Getters and Setters
        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
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

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }
    }
}
