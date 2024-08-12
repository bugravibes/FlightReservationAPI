package com.example.model;

import java.util.List;

public class FlightTicketingResponse {

    private TicketingResponse ticketingResponse;

    public TicketingResponse getTicketingResponse() {
        return ticketingResponse;
    }

    public void setTicketingResponse(TicketingResponse ticketingResponse) {
        this.ticketingResponse = ticketingResponse;
    }

    public static class TicketingResponse {
        private String reservationId;
        private String status;
        private Flight flight;
        private List<Passenger> passengers;
        private Payment payment;
        private ContactInfo contactInfo;

        // Getters and Setters
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

        public Flight getFlight() {
            return flight;
        }

        public void setFlight(Flight flight) {
            this.flight = flight;
        }

        public List<Passenger> getPassengers() {
            return passengers;
        }

        public void setPassengers(List<Passenger> passengers) {
            this.passengers = passengers;
        }

        public Payment getPayment() {
            return payment;
        }

        public void setPayment(Payment payment) {
            this.payment = payment;
        }

        public ContactInfo getContactInfo() {
            return contactInfo;
        }

        public void setContactInfo(ContactInfo contactInfo) {
            this.contactInfo = contactInfo;
        }
    }
}
