package com.carwash.carwash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carwash.carwash.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  
}
