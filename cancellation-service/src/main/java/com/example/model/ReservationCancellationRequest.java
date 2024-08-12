package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationCancellationRequest {

    @JsonProperty("cancellation_request")
    private CancellationRequest cancellation_request;

    public static class CancellationRequest {

        @JsonProperty("client_id")
        private String client_id;

        @JsonProperty("client_password")
        private String client_password;

        @JsonProperty("reservation_id")
        private String reservation_id;

        @JsonProperty("reason")
        private String reason;

        public String getClient_id() { return client_id; }
        public void setClient_id(String client_id) { this.client_id = client_id; }

        public String getClient_password() { return client_password; }
        public void setClient_password(String client_password) { this.client_password = client_password; }

        public String getReservation_id() { return reservation_id; }
        public void setReservation_id(String reservation_id) { this.reservation_id = reservation_id; }

        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
    }

    public CancellationRequest getCancellation_request() {
        return cancellation_request;
    }

    public void setCancellation_request(CancellationRequest cancellation_request) {
        this.cancellation_request = cancellation_request;
    }
}
