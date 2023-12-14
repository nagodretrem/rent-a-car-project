package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;


    @GetMapping()
    public List<GetBrandListResponse> getAll(){
        return brandService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    public void add(@RequestBody AddBrandRequest addBrandRequest){
        this.brandService.add(addBrandRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
