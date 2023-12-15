package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetCarListResponse> getAll() {
        List<Car> cars=carRepository.findAll();
        List<GetCarListResponse> response= cars
                .stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car,GetCarListResponse.class)).collect(Collectors.toList());

        return response;

    }

    @Override
    public void add(AddCarRequest addCarRequest) {
        addCarRequest.setPlateNumber(addCarRequest.getPlateNumber().replaceAll("\s", "").toUpperCase());

        if(carRepository.existsByPlateNumber(addCarRequest.getPlateNumber())){

            throw new RuntimeException("Aynı plaka tekrar girilemez");
        }
        Car car=this.modelMapperService.forRequest().map(addCarRequest,Car.class);
        this.carRepository.save(car);


    }

    @Override
    public GetCarResponse getById(int id) {
        Car car=this.carRepository.findById(id).orElseThrow();
        GetCarResponse response=this.modelMapperService.forResponse().map(car,GetCarResponse.class);
        return response;

    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {
        Car car=this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        this.carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);

    }
}
