package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.RentalRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Service
public class RentalBusinessRules {

    private RentalRepository rentalRepository;
    private CarService carService;
    private UserService userService;

    public void  checkIfCarIdNotExists(int id){
        if (!carService.existsById(id)){
            throw new BusinessException(Messages.CARID_NOT_EXIST);
        }
    }

    public void checkIfUserIdNotExists(int id){
        if (!userService.existsById(id)){
            throw new BusinessException(Messages.USERID_NOT_EXISTS);
        }
    }



    public void checkIfRentalIdNotExists(int id){
        if (!rentalRepository.existsById(id)){
            throw new BusinessException(Messages.RENTALID_NOT_EXISTS);
        }
    }

    public void checkIfStartDateAfterBeforeDate(LocalDate startDate,LocalDate endDate){
        if (startDate.isAfter(endDate)){
            throw new BusinessException(Messages.START_DATE_AFTER_BEFORE_DATE);
        }
    }
    public void checkIfMaxRentalDate(LocalDate startDate,LocalDate endDate){
        if (ChronoUnit.DAYS.between(startDate,endDate) > 25){
            throw new BusinessException(Messages.MAX_DAYS_ERROR);
        }
    }



}
