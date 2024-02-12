package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.constants.Messages;
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
            throw new BusinessException(Messages.PLATE_ALREADY_EXISTS);
        }
    }

    public void checkIfModelIdNotExists(int id){
        if (!modelService.existsById(id)){
            throw new BusinessException(Messages.MODEL_NOT_EXIST);
        }
    }

    public void checkIfColorIdNotExists(int id){
        if (!colorService.existsById(id)){
            throw new BusinessException(Messages.COLOR_NOT_EXIST);
        }
    }

    public String plateStandart(String plate){
        return plate.replaceAll("\s", "").toUpperCase();
    }


}
