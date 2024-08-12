package com.example.repository;

import com.example.entity.ContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfoEntity, Long> {

    @Query("SELECT c FROM ContactInfoEntity c JOIN PassengerEntity p ON c.id = p.contactInfo.id WHERE p.id = :passengerId")
    ContactInfoEntity findByPassengerId(@Param("passengerId") Long passengerId);
}
