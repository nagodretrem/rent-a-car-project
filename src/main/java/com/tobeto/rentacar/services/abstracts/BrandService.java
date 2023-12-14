package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetBrandListResponse> getAll();
    GetBrandResponse getById(int id);
    void add(AddBrandRequest addBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
