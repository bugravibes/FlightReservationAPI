package com.example.repository;

import com.example.entity.ReservationPassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationPassengerRepository extends JpaRepository<ReservationPassengerEntity, Long> {
}
