package com.example.repository;

import com.example.entity.BillingAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddressEntity, String> {
}
