package com.example.repository;

import com.example.entity.CancellationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancellationRepository extends JpaRepository<CancellationEntity, Long> {
}
