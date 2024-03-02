package com.carwash.carwash.model.Customer;

public record CustomerResponse(
    String name,
    String address,
    String phone,
    String email) {
}
