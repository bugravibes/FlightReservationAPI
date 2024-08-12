package com.example.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RESERVATIONS")
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "RESERVATION_ID", nullable = false)
    private String reservationId;

    @Column(name = "CLIENT_ID", nullable = false)
    private String clientId;

    @Column(name = "FLIGHT_ID", nullable = false)
    private String flightId;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_ID", nullable = false)
    private PaymentDetailsEntity paymentDetails;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "CONTACT_INFO_ID", nullable = false)
    private ContactInfoEntity contactInfo;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Set<ReservationPassengerEntity> reservationPassengers = new HashSet<>();

    public Set<ReservationPassengerEntity> getReservationPassengers() {
        return reservationPassengers;
    }

    public void setReservationPassengers(Set<ReservationPassengerEntity> reservationPassengers) {
        this.reservationPassengers = reservationPassengers;
    }

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

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public PaymentDetailsEntity getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetailsEntity paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ContactInfoEntity getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfoEntity contactInfo) {
        this.contactInfo = contactInfo;
    }
}
