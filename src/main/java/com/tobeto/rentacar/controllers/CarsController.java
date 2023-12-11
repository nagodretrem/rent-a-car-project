package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.Car;
import com.tobeto.rentacar.repositories.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarsController {
    private final CarRepository carRepository;

    public CarsController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAll(){
        return carRepository.findAll();
    }
}
