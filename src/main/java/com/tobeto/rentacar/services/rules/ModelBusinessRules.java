package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.repositories.ModelRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;
    private BrandService brandService;

    public void checkIfModelNameExists(String name){
        if (modelRepository.existsByName(nameStandart(name))){
            throw new BusinessException(Messages.MODEL_ALREADY_EXISTS);
        }
    }

    public void checkIfBrandIdNotExists(int id){
        if (!brandService.existsById(id)){
            throw new BusinessException(Messages.BRANDID_NOT_EXISTS);
        }
    }

    public String nameStandart(String name){
        String standartName = name.trim();
        return standartName.substring(0,1).toUpperCase() + standartName.substring(1).toLowerCase();
    }

}
