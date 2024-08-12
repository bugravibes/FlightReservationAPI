package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

public class ReservationSearchResponse {

    @JsonProperty("reservation_info_response")
    private ReservationInfoResponse reservationInfoResponse;

    public ReservationInfoResponse getReservationInfoResponse() {
        return reservationInfoResponse;
    }

    public void setReservationInfoResponse(ReservationInfoResponse reservationInfoResponse) {
        this.reservationInfoResponse = reservationInfoResponse;
    }

    public static class ReservationInfoResponse {
        @JsonProperty("reservation_id")
        private String reservationId;

        @JsonProperty("status")
        private String status;

        @JsonProperty("flight")
        private Flight flight;

        @JsonProperty("passengers")
        private List<Passenger> passengers;

        @JsonProperty("payment")
        private Payment payment;

        @JsonProperty("contact_info")
        private ContactInfo contactInfo;

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

    public static class Flight {
        @JsonProperty("flight_number")
        private String flight_number;

        @JsonProperty("airline")
        private String airline;

        @JsonProperty("departure")
        private Departure departure;

        @JsonProperty("arrival")
        private Arrival arrival;

        @JsonProperty("class")
        private String flightClass;


        public String getFlight_number() {
            return flight_number;
        }

        public void setFlight_number(String flight_number) {
            this.flight_number = flight_number;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public Departure getDeparture() {
            return departure;
        }

        public void setDeparture(Departure departure) {
            this.departure = departure;
        }

        public Arrival getArrival() {
            return arrival;
        }

        public void setArrival(Arrival arrival) {
            this.arrival = arrival;
        }

        public String getFlightClass() {
            return flightClass;
        }

        public void setFlightClass(String flightClass) {
            this.flightClass = flightClass;
        }

        public static class Departure {
            @JsonProperty("airport")
            private String airport;

            @JsonProperty("city")
            private String city;

            @JsonProperty("time")
            private Date time;

            public Departure(String departureAirport, String departureCity, Date departureTime) {
                this.airport = departureAirport;
                this.city = departureCity;
                this.time = departureTime;
            }


            public String getAirport() {
                return airport;
            }

            public void setAirport(String airport) {
                this.airport = airport;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Date getTime() {
                return time;
            }

            public void setTime(Date time) {
                this.time = time;
            }
        }

        public static class Arrival {
            @JsonProperty("airport")
            private String airport;

            @JsonProperty("city")
            private String city;

            @JsonProperty("time")
            private Date time;

            public Arrival(String arrivalAirport, String arrivalCity, Date arrivalTime) {

                this.airport = arrivalAirport;
                this.city = arrivalCity;
                this.time = arrivalTime;

            }


            public String getAirport() {
                return airport;
            }

            public void setAirport(String airport) {
                this.airport = airport;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public Date getTime() {
                return time;
            }

            public void setTime(Date time) {
                this.time = time;
            }
        }
    }

    public static class Location {
        @JsonProperty("airport")
        private String airport;

        @JsonProperty("city")
        private String city;

        @JsonProperty("time")
        private ZonedDateTime time;

        public Location(String departureAirport, String departureCity, LocalDateTime departureTime) {
        }

        public String getAirport() {
            return airport;
        }

        public void setAirport(String airport) {
            this.airport = airport;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public ZonedDateTime getTime() {
            return time;
        }

        public void setTime(ZonedDateTime time) {
            this.time = time;
        }
    }

    public static class Passenger {
        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("dob")
        private String dob;

        @JsonProperty("passport_number")
        private String passportNumber;

        @JsonProperty("nationality")
        private String nationality;

        @JsonProperty("ticket_number")
        private String ticketNumber;

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

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
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

        public String getTicketNumber() {
            return ticketNumber;
        }

        public void setTicketNumber(String ticketNumber) {
            this.ticketNumber = ticketNumber;
        }
    }

    public static class Payment {
        @JsonProperty("method")
        private String method;

        @JsonProperty("amount")
        private double amount;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("transaction_id")
        private String transactionId;

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

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }
    }

    public static class ContactInfo {
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
}
