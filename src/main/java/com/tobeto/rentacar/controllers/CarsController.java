package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repositories.CarRepository;
import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.dtos.requests.car.AddCarRequest;
import com.tobeto.rentacar.services.dtos.requests.car.UpdateCarRequest;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cars")
@AllArgsConstructor
public class CarsController {

    private CarService carService;


    @GetMapping()
    public List<GetCarListResponse> getAll(){

        return carService.getAll();
    }

    @GetMapping({"/{id}"})
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }

    @PostMapping()
    public void add(@RequestBody AddCarRequest addCarRequest) {
        this.carService.add(addCarRequest);

    }
    @PutMapping()
    public void update(@RequestBody UpdateCarRequest updateCarRequest){
        this.carService.update(updateCarRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.carService.delete(id);
    }
}
