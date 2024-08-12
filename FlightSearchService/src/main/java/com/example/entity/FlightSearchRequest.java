package com.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightSearchRequest {

    @JsonProperty("search_request")
    private SearchRequest searchRequest;

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    public static class SearchRequest {
        @JsonProperty("client_id")
        private String clientId;

        @JsonProperty("client_password")
        private String clientPassword;

        private Location departure;
        private Location arrival;

        @JsonProperty("departure_date")
        private String departureDate;

        @JsonProperty("return_date")
        private String returnDate;

        private Passengers passengers;

        @JsonProperty("class")
        private String flightClass;

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

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
        }

        public String getReturnDate() {
            return returnDate;
        }

        public void setReturnDate(String returnDate) {
            this.returnDate = returnDate;
        }

        public Passengers getPassengers() {
            return passengers;
        }

        public void setPassengers(Passengers passengers) {
            this.passengers = passengers;
        }

        public String getFlightClass() {
            return flightClass;
        }

        public void setFlightClass(String flightClass) {
            this.flightClass = flightClass;
        }
    }

    public static class Location {
        private String airport;
        private String city;

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
    }

    public static class Passengers {
        private int adults;
        private int children;
        private int infants;

        public int getAdults() {
            return adults;
        }

        public void setAdults(int adults) {
            this.adults = adults;
        }

        public int getChildren() {
            return children;
        }

        public void setChildren(int children) {
            this.children = children;
        }

        public int getInfants() {
            return infants;
        }

        public void setInfants(int infants) {
            this.infants = infants;
        }
    }
}
