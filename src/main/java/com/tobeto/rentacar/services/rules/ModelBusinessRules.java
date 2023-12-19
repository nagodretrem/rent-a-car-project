package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.repositories.ModelRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ModelBusinessRules {
    private ModelRepository modelRepository;
    private BrandService brandService;

    public void checkIfModelNameExists(String name){
        if (modelRepository.existsByName(nameStandart(name))){
            throw new BusinessException("Model name already exists");
        }
    }

    public void checkIfBrandIdNotExists(int id){
        if (!brandService.existsById(id)){
            throw new BusinessException("BrandId not found");
        }
    }

    public String nameStandart(String name){
        String standartName = name.trim();
        return standartName.substring(0,1).toUpperCase() + standartName.substring(1).toLowerCase();
    }

}
