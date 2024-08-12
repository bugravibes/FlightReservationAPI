package com.example.repository;

import com.example.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity, Long> {
    ContactInfoEntity findByReservation_Id(Long reservation_id); // Use correct property for the query method
}
