package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
