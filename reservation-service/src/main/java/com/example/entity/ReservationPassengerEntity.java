package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESERVATION_PASSENGERS")
public class ReservationPassengerEntity {

    @EmbeddedId
    private ReservationPassengerId id;

    @ManyToOne
    @MapsId("reservationId")
    @JoinColumn(name = "RESERVATION_ID")
    private ReservationEntity reservation;

    @ManyToOne
    @MapsId("passengerId")
    @JoinColumn(name = "PASSENGER_ID")
    private PassengerEntity passenger;

    public ReservationPassengerId getId() {
        return id;
    }

    public void setId(ReservationPassengerId id) {
        this.id = id;
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

