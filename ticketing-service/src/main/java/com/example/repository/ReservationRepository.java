package com.example.repository;

import com.example.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    ReservationEntity findByReservationId(String reservationId);
}