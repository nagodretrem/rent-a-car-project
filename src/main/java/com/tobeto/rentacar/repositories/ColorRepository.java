package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    boolean existsById(int id);
    boolean existsByName(String name);
}
