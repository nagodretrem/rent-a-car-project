package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Discount;
import com.tobeto.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiscountRepository extends JpaRepository<Discount, Integer> {

    Optional<Discount> findByName(String name);



}
