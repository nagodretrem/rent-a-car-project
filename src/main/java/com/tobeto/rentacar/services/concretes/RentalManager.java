package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Car;
import com.tobeto.rentacar.entities.concretes.Rental;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.repositories.RentalRepository;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalResponse;
import com.tobeto.rentacar.services.rules.RentalBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private RentalBusinessRules rentalBusinessRules;
    private ModelMapperService modelMapperService;
    private CarRepository carRepository;


    @Override
    public List<GetRentalListResponse> getAll() {
        List<Rental> rentals = this.rentalRepository.findAll();
        List<GetRentalListResponse> responses = rentals.stream()
                .map(rental -> this.modelMapperService.forResponse()
                        .map(rental, GetRentalListResponse.class)).collect(Collectors.toList());
        return responses;    }

    @Override
    public GetRentalResponse getById(int id) {
        Rental rental = this.rentalRepository.findById(id).orElseThrow();
        GetRentalResponse response = this.modelMapperService.forResponse()
                .map(rental, GetRentalResponse.class);

        return response;
    }

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        rentalBusinessRules.checkIfCarIdNotExists(addRentalRequest.getCarId());
        rentalBusinessRules.checkIfCustomerIdNotExists(addRentalRequest.getUserId());
        rentalBusinessRules.checkIfStartDateAfterBeforeDate(addRentalRequest.getStartDate(),addRentalRequest.getEndDate());
        rentalBusinessRules.checkIfMaxRentalDate(addRentalRequest.getStartDate(),addRentalRequest.getEndDate());
        Car car = this.carRepository.findById(addRentalRequest.getCarId()).orElseThrow();


        Rental rental=this.modelMapperService.forRequest().map(addRentalRequest,Rental.class);

        this.rentalRepository.save(rental);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
        rentalBusinessRules.checkIfCarIdNotExists(updateRentalRequest.getCarId());
        rentalBusinessRules.checkIfCustomerIdNotExists(updateRentalRequest.getUserId());
        rentalBusinessRules.checkIfStartDateAfterBeforeDate(updateRentalRequest.getStartDate(),updateRentalRequest.getEndDate());
        rentalBusinessRules.checkIfMaxRentalDate(updateRentalRequest.getStartDate(),updateRentalRequest.getEndDate());
        Car car = this.carRepository.findById(updateRentalRequest.getCarId()).orElseThrow();

        Rental rental=this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);

        this.rentalRepository.save(rental);
    }

    @Override
    public void delete(int id) {
            this.rentalRepository.deleteById(id);
    }
}
