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
    public  void checkIfUserGsmExists(String gsm) {
        if (userRepository.existsByGsm(gsm)) {
            throw new BusinessException("Gsm already exists");
        }
    }


    public void checkIfUserIdNotExists(int id) {
        if (!userRepository.existsById(id)) {
            throw new BusinessException("UserId not found");
        }
    }

    public String nameStandart(String name){
        String standartName = name.trim();
        return standartName.substring(0,1).toUpperCase() + standartName.substring(1).toLowerCase();
    }

    public String surnameStandart(String surname){
        String standartSurname = surname.trim();
        return standartSurname.toUpperCase();
    }



}
