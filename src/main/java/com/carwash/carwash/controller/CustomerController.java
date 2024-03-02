package com.carwash.carwash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.carwash.domain.Customer;
import com.carwash.carwash.model.Customer.CustomerRequest;
import com.carwash.carwash.model.Customer.CustomerResponse;
import com.carwash.carwash.model.Customer.UpdateCustomerRequest;
import com.carwash.carwash.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carwash/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @PostMapping
  public ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request) {
    CustomerResponse customer = customerService.createCustomer(request);

    return ResponseEntity.ok(customer);
  }

  @GetMapping
  public ResponseEntity<List<Customer>> allCustomers() {

    List<Customer> customers = customerService.allCustomers();

    return ResponseEntity.ok(customers);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateCustomer(@PathVariable @NonNull Long id,
      @RequestBody UpdateCustomerRequest request) {
    return ResponseEntity.ok(customerService.updateCustomer(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCustomer(@PathVariable @NonNull Long id) {
    return ResponseEntity.ok(customerService.deleteCustomer(id));
  }
}
