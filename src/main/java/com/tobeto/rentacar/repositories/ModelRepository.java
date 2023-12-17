package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    boolean existsByName(String name);
    boolean existsByBrandId(int brand_id);

}
