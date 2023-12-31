package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Model;
import com.tobeto.rentacar.repositories.ModelRepository;
import com.tobeto.rentacar.services.abstracts.ModelService;
import com.tobeto.rentacar.services.dtos.requests.model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelResponse;
import com.tobeto.rentacar.services.rules.ModelBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;
    @Override
    public List<GetModelListResponse> getAll() {
        List<Model> models=this.modelRepository.findAll();
        List<GetModelListResponse> response=models.stream().
                map(model -> this.modelMapperService.forResponse().
                        map(model,GetModelListResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model=this.modelRepository.findById(id).orElseThrow();
        GetModelResponse response=this.modelMapperService.forResponse()
                .map(model,GetModelResponse.class);
        return response;
    }

    @Override
    public void add(AddModelRequest addModelRequest) {

        modelBusinessRules.checkIfModelNameExists(addModelRequest.getName());

        Model model=this.modelMapperService.forRequest().map(addModelRequest,Model.class);
        model.setName(modelBusinessRules.nameStandart(model.getName()));
        this.modelRepository.save(model);
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model=this.modelMapperService.forRequest().map(updateModelRequest,Model.class);
        model.setName(modelBusinessRules.nameStandart(model.getName()));
        this.modelRepository.save(model);

    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);

    }

    @Override
    public boolean existsById(int id) {
        return this.modelRepository.existsById(id);
    }
}
