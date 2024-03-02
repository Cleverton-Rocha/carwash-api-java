package com.carwash.carwash.domain;

import java.util.List;

import com.carwash.carwash.model.Customer.CustomerRequest;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Table(name = "Customer", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
@Entity
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String address;

  @Column(nullable = false)
  private String phone;

  @Column(nullable = false, unique = true)
  private String email;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Car> cars;

  public void createCustomer(CustomerRequest request) {
    this.name = request.name();
    this.address = request.address();
    this.phone = request.phone();
    this.email = request.email();
  }
}
