package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsById(int id);
    boolean existsByName(String name);


}
