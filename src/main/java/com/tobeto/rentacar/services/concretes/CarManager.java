package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarResponse;
import com.tobeto.rentacar.services.rules.CarBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private final CarRepository carRepository;
    private ModelMapperService modelMapperService;
    private CarBusinessRules carBusinessRules;
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

        carBusinessRules.checkIfCarPlateExists(addCarRequest.getPlateNumber());
        carBusinessRules.checkIfColorIdNotExists(addCarRequest.getModelId());
        carBusinessRules.checkIfModelIdNotExists(addCarRequest.getModelId());


        Car car=this.modelMapperService.forRequest().map(addCarRequest,Car.class);
        car.setPlateNumber(carBusinessRules.plateStandart(car.getPlateNumber()));
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
        carBusinessRules.checkIfColorIdNotExists(updateCarRequest.getModelId());
        carBusinessRules.checkIfModelIdNotExists(updateCarRequest.getModelId());


        Car car=this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
        car.setPlateNumber(carBusinessRules.plateStandart(car.getPlateNumber()));
        this.carRepository.save(car);

    }

    @Override
    public void delete(int id) {
        this.carRepository.deleteById(id);

    }

    @Override
    public boolean existsById(int id) {
        return this.carRepository.existsById(id);
    }
}
