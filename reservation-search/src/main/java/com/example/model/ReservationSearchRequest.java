package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReservationSearchRequest {

    @JsonProperty("reservation_info_request")
    private ReservationInfoRequest reservationInfoRequest;

    public ReservationInfoRequest getReservationInfoRequest() {
        return reservationInfoRequest;
    }

    public void setReservationInfoRequest(ReservationInfoRequest reservationInfoRequest) {
        this.reservationInfoRequest = reservationInfoRequest;
    }

    public static class ReservationInfoRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_password")
        private String clientPassword;

        @JsonProperty("reservation_id")
        private String reservationId;

        @JsonProperty("passenger")
        private Passenger passenger;

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

        public Passenger getPassenger() {
            return passenger;
        }

        public void setPassenger(Passenger passenger) {
            this.passenger = passenger;
        }
    }

    public static class Passenger {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

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
    }
}
