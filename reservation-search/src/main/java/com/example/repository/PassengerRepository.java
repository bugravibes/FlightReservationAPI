package com.example.repository;

import com.example.entity.PassengerEntity;
import com.example.entity.ReservationPassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
    List<PassengerEntity> findByReservationPassengers_ReservationId(Long reservationId);
}