package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.DiscountService;
import com.tobeto.rentacar.services.dtos.requests.discount.AddDiscountRequest;
import com.tobeto.rentacar.services.dtos.requests.discount.UpdateDiscountRequest;
import com.tobeto.rentacar.services.dtos.responses.dicount.GetDiscountListResponse;
import com.tobeto.rentacar.services.dtos.responses.dicount.GetDiscountResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/discount")
@AllArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping
    public List<GetDiscountListResponse> getAll(){
        return discountService.getAll();
    }

    @GetMapping({"/{stringCode}"})
    public GetDiscountResponse getByCode(@PathVariable String stringCode){
        return discountService.getByCode(stringCode);

    }

    @PostMapping
    public void add(@RequestBody @Valid AddDiscountRequest addDiscountRequest){
        discountService.add(addDiscountRequest);
    }

    @PutMapping
    public void update(@RequestBody @Valid UpdateDiscountRequest updateDiscountRequest){
        discountService.update(updateDiscountRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        discountService.delete(id);
    }



}
