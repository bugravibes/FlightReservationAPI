package com.example.repository;

import com.example.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, String> {
    FlightEntity findByFlightNumber(String flightNumber);
}