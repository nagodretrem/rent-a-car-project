package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer>
{
    boolean existsById(int id);
    boolean existsByName(String name);
}
