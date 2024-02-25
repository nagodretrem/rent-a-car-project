package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.entities.concretes.Customer;
import com.tobeto.rentacar.services.abstracts.CustomerService;
import com.tobeto.rentacar.services.dtos.requests.customer.AddCustomerRequest;
import com.tobeto.rentacar.services.dtos.requests.customer.UpdateCustomerRequest;
import com.tobeto.rentacar.services.dtos.responses.customer.GetCustomerListResponse;
import com.tobeto.rentacar.services.dtos.responses.customer.GetCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomersController {
    private CustomerService customerService;

    @GetMapping()
    public List<GetCustomerListResponse> getAll(){
        return customerService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetCustomerResponse getById(@PathVariable int id){
        return customerService.getById(id);
    }
    @PostMapping()
    public int add(@RequestBody @Valid AddCustomerRequest addCustomerRequest){
        Customer customer = this.customerService.add(addCustomerRequest);

        return customer.getId();
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateCustomerRequest updateCustomerRequest){
        this.customerService.update(updateCustomerRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.customerService.delete(id);
    }
}
