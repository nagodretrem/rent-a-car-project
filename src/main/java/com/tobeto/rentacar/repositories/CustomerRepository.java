package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsById(int id);

    boolean existsByNationalityId(String nationality);
}
