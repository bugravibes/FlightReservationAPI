package com.example.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "RESERVATIONS")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RESERVATION_ID", nullable = false)
    private String reservationId;

    @Column(name = "CLIENT_ID", nullable = false)
    private String clientId;

    @Column(name = "FLIGHT_ID", nullable = false)
    private String flightNumber;

    @Column(name = "PAYMENT_ID", nullable = false)
    private Long paymentId;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "CONTACT_INFO_ID", nullable = false)
    private Long contactInfoId;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<ReservationPassengerEntity> reservationPassengers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(Long contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public Set<ReservationPassengerEntity> getReservationPassengers() {
        return reservationPassengers;
    }

    public void setReservationPassengers(Set<ReservationPassengerEntity> reservationPassengers) {
        this.reservationPassengers = reservationPassengers;
    }
}

