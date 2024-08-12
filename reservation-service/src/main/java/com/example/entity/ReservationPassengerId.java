package com.example.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationPassengerId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long reservationId;
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
