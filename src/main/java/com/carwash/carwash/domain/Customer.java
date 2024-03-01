package com.carwash.carwash.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "Customer")
@Entity
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false )
  private String address;

  @Column(nullable = false)
  private Integer phone;

  @Column(nullable = false)
  private String email;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<Car> cars;
}
