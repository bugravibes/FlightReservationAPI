package com.example.entity;

import java.io.Serializable;
import java.util.Objects;

public class ReservationPassengerId implements Serializable {

    private String reservationId;
    private Long passengerId;

    public ReservationPassengerId() {}

    public ReservationPassengerId(String reservationId, Long passengerId) {
        this.reservationId = reservationId;
        this.passengerId = passengerId;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationPassengerId that = (ReservationPassengerId) o;
        return Objects.equals(reservationId, that.reservationId) &&
                Objects.equals(passengerId, that.passengerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, passengerId);
    }
}