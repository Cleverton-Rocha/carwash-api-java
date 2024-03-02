package com.carwash.carwash.model.Customer;

public record UpdateCustomerRequest(
    String name,
    String address,
    String phone,
    String email) {

}
