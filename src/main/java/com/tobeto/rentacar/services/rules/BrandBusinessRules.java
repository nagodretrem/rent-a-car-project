package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public void checkIfBrandNameExists(String name){
        if (brandRepository.existsByName(nameStandard(name))){
            throw new BusinessException(Messages.BRAND_ALREADY_EXISTS);
        }
    }

    public String nameStandard(String name){
        String standartName = name.trim();
        return standartName.substring(0,1).toUpperCase() + standartName.substring(1).toLowerCase();
    }
}
