package com.example.repository;

import com.example.entity.PassengerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, Long> {
}
