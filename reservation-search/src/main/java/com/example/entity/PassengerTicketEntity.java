package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "passenger_tickets")
public class PassengerTicketEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number", nullable = false)
    private String ticketNumber;

    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;

    @Column(name = "passenger_id", nullable = false)
    private Long passengerId;

    @ManyToOne
    @JoinColumn(name = "reservation_id", insertable = false, updatable = false)
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "passenger_id", insertable = false, updatable = false)
    private PassengerEntity passenger;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public ReservationEntity getReservation() {
        return reservation;
    }

    public void setReservation(ReservationEntity reservation) {
        this.reservation = reservation;
    }

    public PassengerEntity getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerEntity passenger) {
        this.passenger = passenger;
    }
}
