package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RESERVATIONS")
public class ReservationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "RESERVATION_ID", nullable = false)
    private String reservationId;

    @Column(name = "STATUS", nullable = false)
    private String status;

    // Getters and setters

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
