package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.concretes.Rental;
import com.tobeto.rentacar.services.abstracts.RentalService;
import com.tobeto.rentacar.services.dtos.requests.rental.AddRentalRequest;
import com.tobeto.rentacar.services.dtos.requests.rental.UpdateRentalRequest;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalListResponse;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
@AllArgsConstructor
public class RentalsController {
    private RentalService rentalService;

    @GetMapping()
    public List<GetRentalListResponse> getAll(){
        return rentalService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetRentalResponse getById(@PathVariable int id){
        return rentalService.getById(id);
    }
    @PostMapping()
    public int add(@RequestBody @Valid AddRentalRequest addRentalRequest) {
        Rental rental = this.rentalService.add(addRentalRequest);

        return rental.getId();

    }


    @PutMapping()
    public void update(@RequestBody @Valid UpdateRentalRequest updateRentalRequest){
        this.rentalService.update(updateRentalRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.rentalService.delete(id);
    }
}
