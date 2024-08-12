package com.example.repository;

import com.example.entity.PassengerTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerTicketRepository extends JpaRepository<PassengerTicketEntity, Long> {
    List<PassengerTicketEntity> findByReservationId(Long reservationId);
}
