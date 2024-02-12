package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.ColorRepository;
import com.tobeto.rentacar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ColorBusinessRules {

    private ColorRepository colorRepository;

    public void checkIfColorNameExists(String name){
        if (colorRepository.existsByName(nameStandart(name))){
            throw new BusinessException(Messages.COLOR_ALREADY_EXISTS);
        }
    }

    public String nameStandart(String name){
        String standartName = name.trim();
        return standartName.substring(0,1).toUpperCase() + standartName.substring(1).toLowerCase();
    }
}
