package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ReservationPassengerId implements Serializable {

    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @Column(name = "PASSENGER_ID")
    private Long passengerId;

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
}
