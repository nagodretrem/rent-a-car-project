package com.tobeto.rentacar.services.rules;

import com.tobeto.rentacar.core.utilities.exceptions.BusinessException;
import com.tobeto.rentacar.repositories.RentalRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@Service
public class RentalBusinessRules {

    private RentalRepository rentalRepository;
    private CarService carService;
    private CustomerService customerService;

    public void  checkIfCarIdNotExists(int id){
        if (!carService.existsById(id)){
            throw new BusinessException("CarId not found");
        }
    }

    public void checkIfCustomerIdNotExists(int id){
        if (!customerService.existsById(id)){
            throw new BusinessException("CustomerId not found");
        }
    }



    public void checkIfRentalIdNotExists(int id){
        if (!rentalRepository.existsById(id)){
            throw new BusinessException("RentalId not found");
        }
    }

    public void checkIfStartDateAfterBeforeDate(LocalDate startDate,LocalDate endDate){
        if (startDate.isAfter(endDate)){
            throw new BusinessException("Start date must be before end date");
        }
    }
    public void checkIfMaxRentalDate(LocalDate startDate,LocalDate endDate){
        if (ChronoUnit.DAYS.between(startDate,endDate) > 25){
            throw new BusinessException("Rental date must be less than 25 days");
        }
    }

    public double calculateTotalPrice(double dailyPrice, double discount, LocalDate startDate, LocalDate endDate) {
        double totalPrice = 0;
        if (discount > 0 && discount < 100) {
            totalPrice = (endDate.toEpochDay() - startDate.toEpochDay()) * dailyPrice * (1 - (discount / 100));
        } else {
            totalPrice = (endDate.toEpochDay() - startDate.toEpochDay()) * dailyPrice;
        }
        return totalPrice;

    }

}
