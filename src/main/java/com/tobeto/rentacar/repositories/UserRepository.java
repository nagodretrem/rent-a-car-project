package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(int id);

    boolean existsByEmail(String email);

    boolean existsByGsm(String gsm);
}
