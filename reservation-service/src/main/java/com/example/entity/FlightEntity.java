package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FLIGHTS")
public class FlightEntity {
    @Id
    @Column(name = "FLIGHT_NUMBER", nullable = false)
    private String flightNumber;

    @Column(name = "AIRLINE", nullable = false)
    private String airline;

    @Column(name = "DEPARTURE_AIRPORT", nullable = false)
    private String departureAirport;

    @Column(name = "DEPARTURE_CITY", nullable = false)
    private String departureCity;

    @Column(name = "ARRIVAL_AIRPORT", nullable = false)
    private String arrivalAirport;

    @Column(name = "ARRIVAL_CITY", nullable = false)
    private String arrivalCity;

    @Column(name = "DEPARTURE_TIME", nullable = false)
    private Date departureTime;

    @Column(name = "ARRIVAL_TIME", nullable = false)
    private Date arrivalTime;

    @Column(name = "PRICE", nullable = false)
    private double price;

    @Column(name = "AVAILABILITY", nullable = false)
    private int availability;

    @Column(name = "FLIGHT_CLASS", nullable = false)
    private String flightClass;

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

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }
}
