package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetModelListResponse> getAll(){
        return modelService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }
    @PostMapping()
    public void add(@RequestBody AddModelRequest addModelRequest){
        this.modelService.add(addModelRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }
}
