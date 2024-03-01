package com.carwash.carwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.carwash.domain.Customer;
import com.carwash.carwash.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Transactional
  public List<Customer> allCustomers() {
    return customerRepository.findAll();
  }
}
