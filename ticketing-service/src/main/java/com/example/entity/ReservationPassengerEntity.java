package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "RESERVATION_PASSENGERS")
@IdClass(ReservationPassengerId.class)
public class ReservationPassengerEntity {

    @Id
    @Column(name = "reservation_id")
    private String reservationId;

    @Id
    @Column(name = "passenger_id")
    private Long passengerId;

    @ManyToOne
    @JoinColumn(name = "reservation_id", insertable = false, updatable = false)
    private ReservationEntity reservation;

    @ManyToOne
    @JoinColumn(name = "passenger_id", insertable = false, updatable = false)
    private PassengerEntity passenger;


    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
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

