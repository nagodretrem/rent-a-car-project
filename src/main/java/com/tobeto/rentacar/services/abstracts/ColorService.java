package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;

import java.util.List;

public interface ColorService {
    List<GetColorListResponse> getAll();
    GetColorResponse getById(int id);
    void add(AddColorRequest addColorRequest);
    void update(UpdateColorRequest updateColorRequest);
    void delete(int id);
}
