package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarResponse;

import java.util.List;

public interface CarService {
    List<GetCarListResponse> getAll();
    void add(AddCarRequest addCarRequest);
    GetCarResponse getById(int id);
    void update(UpdateCarRequest updateCarRequest);
    void delete(int id);


    boolean existsById(int id);
}
