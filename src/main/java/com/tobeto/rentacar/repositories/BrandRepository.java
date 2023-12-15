package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    boolean existsByName(String name);
}
