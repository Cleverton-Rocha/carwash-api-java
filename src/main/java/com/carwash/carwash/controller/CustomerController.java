package com.carwash.carwash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.carwash.domain.Customer;
import com.carwash.carwash.service.CustomerService;

@RestController
@RequestMapping("/carwash/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping
  public ResponseEntity<List<Customer>> allCustomers() {

    List<Customer> customers = customerService.allCustomers();

    return ResponseEntity.ok(customers);
  }
}
