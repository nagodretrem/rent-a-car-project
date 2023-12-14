package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.CarService;
import com.tobeto.rentacar.services.abstracts.ColorService;
import com.tobeto.rentacar.services.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/colors")
@AllArgsConstructor
public class ColorsController {
    private ColorService colorService;
    @GetMapping()
    public List<GetColorListResponse> getAll(){

        return colorService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetColorResponse getById(@PathVariable int id){
        return colorService.getById(id);
    }
    @PostMapping()
    public void add(@RequestBody AddColorRequest addColorRequest){
        this.colorService.add(addColorRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateColorRequest updateColorRequest){
        this.colorService.update(updateColorRequest);
    }
    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.colorService.delete(id);
    }


}
