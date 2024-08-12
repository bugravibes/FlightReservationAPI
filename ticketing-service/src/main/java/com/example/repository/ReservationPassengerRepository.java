package com.example.repository;

import com.example.entity.ReservationPassengerEntity;
import com.example.entity.ReservationPassengerId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationPassengerRepository extends JpaRepository<ReservationPassengerEntity, ReservationPassengerId> {
    List<ReservationPassengerEntity> findByReservationId(String reservationId);
}
