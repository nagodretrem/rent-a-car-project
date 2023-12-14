package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.model.AddModelRequest;
import com.tobeto.rentacar.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest addModelRequest);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);
}
