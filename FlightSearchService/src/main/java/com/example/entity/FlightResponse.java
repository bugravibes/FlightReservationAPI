package com.example.entity;

public class FlightResponse {
    private String flight_number;
    private String airline;
    private Location departure;
    private Location arrival;
    private String duration;
    private Price price;
    private String flight_class;
    private int availability;

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

    public String getFlight_class() {
        return flight_class;
    }

    public void setFlight_class(String flight_class) {
        this.flight_class = flight_class;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public static class Location {
        private String airport;
        private String city;
        private String time;

        public Location(String airport, String city, String time) {
            this.airport = airport;
            this.city = city;
            this.time = time;
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

        public Price(String currency, double amount) {
            this.currency = currency;
            this.amount = amount;
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
