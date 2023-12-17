package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Rental;
import com.tobeto.rentacar.repositories.RentalRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final CarService carService;

    private ModelMapperService modelMapperService;


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
        Long totalDay = ChronoUnit.DAYS.between(addRentalRequest.getStartDate(),addRentalRequest.getEndDate());

        if (addRentalRequest.getEndDate().isBefore(addRentalRequest.getStartDate())) {
            throw new RuntimeException("Bitiş tarihi başlangıç tarihinden daha geçmiş bir tarih olamaz.");
        }
        if (totalDay>25){
            throw new RuntimeException("Bir araç maksimum 25 gün kiralanabilir!");
        }


            Rental rental=this.modelMapperService.forRequest().map(addRentalRequest,Rental.class);
       rental.setStartKilometer(carService.getById(addRentalRequest.getCarId()).getKilometer());
        rental.setTotalPrice(carService.getById(addRentalRequest.getCarId()).
                getDailyPrice()*totalDay.doubleValue());
        this.rentalRepository.save(rental);




    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
        Rental rental=this.modelMapperService.forRequest().map(updateRentalRequest,Rental.class);
        this.rentalRepository.save(rental);
    }

    @Override
    public void delete(int id) {
            this.rentalRepository.deleteById(id);
    }
}
