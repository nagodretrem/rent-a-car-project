package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
