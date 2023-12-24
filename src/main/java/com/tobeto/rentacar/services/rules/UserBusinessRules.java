package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserBusinessRules {

    private final UserRepository userRepository;

    public void checkIfUserEmailExists(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new BusinessException("Email already exists");
        }
    }

    public void checkIfUserIdNotExists(int id) {
        if (!userRepository.existsById(id)) {
            throw new BusinessException("UserId not found");
        }
    }



}
