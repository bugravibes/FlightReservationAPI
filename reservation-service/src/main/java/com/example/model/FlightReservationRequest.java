package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class FlightReservationRequest {

    @JsonProperty("reservation_request")
    private ReservationRequest reservationRequest;

    public ReservationRequest getReservationRequest() {
        return reservationRequest;
    }

    public void setReservationRequest(ReservationRequest reservationRequest) {
        this.reservationRequest = reservationRequest;
    }

    public static class ReservationRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_password")
        private String clientPassword;

        @JsonProperty("flight")
        private Flight flight;

        @JsonProperty("passengers")
        private List<Passenger> passengers;

        @JsonProperty("payment")
        private Payment payment;

        @JsonProperty("contact_info")
        private ContactInfo contactInfo;

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
                private Timestamp time;


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

                public Timestamp getTime() {
                    return time;
                }

                public void setTime(Timestamp time) {
                    this.time = time;
                }
            }

            public static class Arrival {
                @JsonProperty("airport")
                private String airport;

                @JsonProperty("city")
                private String city;

                @JsonProperty("time")
                private Timestamp time;


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

                public Timestamp getTime() {
                    return time;
                }

                public void setTime(Timestamp time) {
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

            public com.example.model.ContactInfo getContactInfo() {
                return contactInfo;
            }

            public void setContactInfo(ContactInfo contactInfo) {
                this.contactInfo = contactInfo;
            }

        }

        public static class Payment {
            @JsonProperty("method")
            private String method;

            @JsonProperty("details")
            private Details details;


            public String getMethod() {
                return method;
            }

            public void setMethod(String method) {
                this.method = method;
            }

            public Details getDetails() {
                return details;
            }

            public void setDetails(Details details) {
                this.details = details;
            }

            public static class Details {
                @JsonProperty("card_number")
                private String cardNumber;

                @JsonProperty("expiry_date")
                private String expiryDate;

                @JsonProperty("cvv")
                private String cvv;

                @JsonProperty("cardholder_name")
                private String cardholderName;

                @JsonProperty("billing_address")
                private BillingAddress billingAddress;


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

                public BillingAddress getBillingAddress() {
                    return billingAddress;
                }

                public void setBillingAddress(BillingAddress billingAddress) {
                    this.billingAddress = billingAddress;
                }

                public static class BillingAddress {
                    @JsonProperty("street")
                    private String street;

                    @JsonProperty("city")
                    private String city;

                    @JsonProperty("state")
                    private String state;

                    @JsonProperty("postal_code")
                    private String postalCode;

                    @JsonProperty("country")
                    private String country;


                    public String getStreet() {
                        return street;
                    }

                    public void setStreet(String street) {
                        this.street = street;
                    }

                    public String getCity() {
                        return city;
                    }

                    public void setCity(String city) {
                        this.city = city;
                    }

                    public String getState() {
                        return state;
                    }

                    public void setState(String state) {
                        this.state = state;
                    }

                    public String getPostalCode() {
                        return postalCode;
                    }

                    public void setPostalCode(String postalCode) {
                        this.postalCode = postalCode;
                    }

                    public String getCountry() {
                        return country;
                    }

                    public void setCountry(String country) {
                        this.country = country;
                    }
                }

            }
        }
        }
        }

