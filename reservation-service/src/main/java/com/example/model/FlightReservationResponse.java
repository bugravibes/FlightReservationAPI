package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class FlightReservationResponse {

    @JsonProperty("reservation_response")
    private ReservationResponse reservationResponse;

    public FlightReservationResponse() {
        this.reservationResponse = new ReservationResponse(); // Initialize here
    }


    public ReservationResponse getReservationResponse() {
        return reservationResponse;
    }

    public void setReservationResponse(ReservationResponse reservationResponse) {
        this.reservationResponse = reservationResponse;
    }

    public static class ReservationResponse {
        @JsonProperty("reservation_id")
        private String reservationId;

        @JsonProperty("status")
        private String status;

        @JsonProperty("flight")
        private Flight flight;

        @JsonProperty("passengers")
        private List<Passenger> passengers;


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

        public static class Passenger {
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

            @JsonProperty("contact_info")
            private ContactInfo contactInfo;


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

            public ContactInfo getContactInfo() {
                return contactInfo;
            }

            public void setContactInfo(ContactInfo contactInfo) {
                this.contactInfo = contactInfo;
            }

        }
    }
}
