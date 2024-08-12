package com.example.repository;

import com.example.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
    List<PassengerEntity> findByReservationPassengers_Reservation_Id(Long id); // Adjust method to use the correct join path
}