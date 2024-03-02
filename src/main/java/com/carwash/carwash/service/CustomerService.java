package com.carwash.carwash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.carwash.carwash.domain.Customer;
import com.carwash.carwash.exception.CustomerNotFoundException;
import com.carwash.carwash.exception.EmailIsNotUniqueException;
import com.carwash.carwash.model.Customer.CustomerRequest;
import com.carwash.carwash.model.Customer.CustomerResponse;
import com.carwash.carwash.model.Customer.UpdateCustomerRequest;
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

  @Transactional
  public CustomerResponse createCustomer(CustomerRequest request) {

    if (customerRepository.findByEmail(request.email()).isPresent()) {
      throw new EmailIsNotUniqueException("Email is already in use.");
    }

    Customer newCustomer = new Customer();
    newCustomer.createCustomer(request);
    customerRepository.save(newCustomer);

    CustomerResponse response = new CustomerResponse(newCustomer.getName(), newCustomer.getAddress(),
        newCustomer.getPhone(), newCustomer.getEmail());

    return response;
  }

  @Transactional
  public String deleteCustomer(@NonNull Long id) {

    Customer customer = customerRepository.findById(id)
        .orElse(null);

    if (customer == null) {
      throw new CustomerNotFoundException("Customer with ID " + id + " does not exist.");
    }

    customerRepository.delete(customer);

    return "Customer with ID " + id + " deleted successfully";
  }

  @Transactional
  public String updateCustomer(@NonNull Long id, UpdateCustomerRequest request) {
    Customer customer = customerRepository.findById(id).orElse(null);

    if (customer == null) {
      throw new CustomerNotFoundException("Customer with ID " + id + " does not exist.");
    }

    if (request.name() != null) {
      customer.setName(request.name());
    }

    if (request.address() != null) {
      customer.setAddress(request.address());
    }

    if (request.phone() != null) {
      customer.setPhone(request.phone());
    }

    if (request.email() != null) {
      if (customerRepository.findByEmail(request.email()).isPresent()) {
        throw new EmailIsNotUniqueException("Email is already in use.");
      }
      customer.setEmail(request.email());
    }

    customerRepository.save(customer);

    return "Customer with ID " + id + " updated successfully.";

  }
}
