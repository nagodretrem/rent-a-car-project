package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.abstracts.ModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarBusinessRules {

    private CarRepository carRepository;
    private ModelService modelService;
    private ColorService colorService;

    public void checkIfCarPlateExists(String plate){
        if (carRepository.existsByPlate(plateStandart(plate))){
            throw new BusinessException("Plate number already exists");
        }
    }

    public void checkIfModelIdNotExists(int id){
        if (!modelService.existsById(id)){
            throw new BusinessException("ModelId not found");
        }
    }

    public void checkIfColorIdNotExists(int id){
        if (!colorService.existsById(id)){
            throw new BusinessException("ColorId not found");
        }
    }

    public String plateStandart(String plate){
        return plate.replaceAll("\s", "").toUpperCase();
    }


}
