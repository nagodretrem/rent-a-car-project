package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

    boolean existsById(int id);
    boolean existsByPlate(String plate);



}
