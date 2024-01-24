package com.tobeto.rentacar.repositories;

import com.tobeto.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsById(int id);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
