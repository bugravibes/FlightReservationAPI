package com.example.entity;

import java.util.List;

public class FlightSearchResponse {

    private List<FlightDetails> flights;

    public List<FlightDetails> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightDetails> flights) {
        this.flights = flights;
    }

    public static class FlightDetails {
        private String flightNumber;
        private String airline;
        private Location departure;
        private Location arrival;
        private String duration;
        private Price price;
        private String flightClass;
        private int availability;

        public String getFlightNumber() {
            return flightNumber;
        }

        public void setFlightNumber(String flightNumber) {
            this.flightNumber = flightNumber;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public Location getDeparture() {
            return departure;
        }

        public void setDeparture(Location departure) {
            this.departure = departure;
        }

        public Location getArrival() {
            return arrival;
        }

        public void setArrival(Location arrival) {
            this.arrival = arrival;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Price getPrice() {
            return price;
        }

        public void setPrice(Price price) {
            this.price = price;
        }

        public String getFlightClass() {
            return flightClass;
        }

        public void setFlightClass(String flightClass) {
            this.flightClass = flightClass;
        }

        public int getAvailability() {
            return availability;
        }

        public void setAvailability(int availability) {
            this.availability = availability;
        }
    }

    public static class Location {
        private String airport;
        private String city;
        private String time;

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

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static class Price {
        private String currency;
        private double amount;

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
