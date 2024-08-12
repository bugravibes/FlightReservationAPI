package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class ReservationCancellationResponse {

    @JsonProperty("cancellation_response")
    private CancellationResponse cancellationResponse;

    public CancellationResponse getCancellationResponse() {
        return cancellationResponse;
    }

    public void setCancellationResponse(CancellationResponse cancellationResponse) {
        this.cancellationResponse = cancellationResponse;
    }

    public static class CancellationResponse {

        @JsonProperty("reservation_id")
        private String reservationId;

        @JsonProperty("status")
        private String status;

        @JsonProperty("refund")
        private Refund refund;

        @JsonProperty("cancellation_fee")
        private CancellationFee cancellationFee;

        @JsonProperty("canceled_at")
        private ZonedDateTime canceledAt;


        public String getReservationId() {
            return reservationId;
        }

        public void setReservationId(String reservationId) {
            this.reservationId = reservationId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Refund getRefund() {
            return refund;
        }

        public void setRefund(Refund refund) {
            this.refund = refund;
        }

        public CancellationFee getCancellationFee() {
            return cancellationFee;
        }

        public void setCancellationFee(CancellationFee cancellationFee) {
            this.cancellationFee = cancellationFee;
        }

        public ZonedDateTime getCanceledAt() {
            return canceledAt;
        }

        public void setCanceledAt(ZonedDateTime canceledAt) {
            this.canceledAt = canceledAt;
        }
    }

    public static class Refund {

        @JsonProperty("amount")
        private double amount;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("transaction_id")
        private String transactionId;

        @JsonProperty("method")
        private String method;

        public Refund() {

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

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }

    public static class CancellationFee {

        @JsonProperty("amount")
        private double amount;

        @JsonProperty("currency")
        private String currency;

        public CancellationFee() {
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
    }
}
