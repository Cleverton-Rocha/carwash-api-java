package com.carwash.carwash.model.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(
        @NotNull String name,
        @NotNull String address,
        @NotNull String phone,
        @NotNull @Email String email) {
}
