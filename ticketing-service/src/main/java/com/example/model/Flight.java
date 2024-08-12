package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;
import java.util.Date;

public class Flight {
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