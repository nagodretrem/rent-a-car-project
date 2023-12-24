package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentacar.services.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.requests.corporatecustomer.AddCorporateCustomerRequest;
import com.tobeto.rentacar.services.dtos.requests.corporatecustomer.UpdateCorporateCustomerRequest;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerListResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/corporatecustomers")
@AllArgsConstructor
public class CorporateCustomersController {
    private CorporateCustomerService corporateCustomerService;
    @GetMapping
    public List<GetCorporateCustomerListResponse> getAll(){

        return corporateCustomerService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetCorporateCustomerResponse getById(@PathVariable int id){
        return corporateCustomerService.getById(id);
    }
    @PostMapping()
    public void add(@RequestBody @Valid AddCorporateCustomerRequest addCorporateCustomerRequest){
        this.corporateCustomerService.add(addCorporateCustomerRequest);
    }
    @PutMapping()
    public void update(@RequestBody @Valid UpdateCorporateCustomerRequest updateCorporateCustomerRequest){
        this.corporateCustomerService.update(updateCorporateCustomerRequest);
    }
    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.corporateCustomerService.delete(id);
    }

}
