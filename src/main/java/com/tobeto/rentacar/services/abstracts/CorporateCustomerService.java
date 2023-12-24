package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.color.AddColorRequest;
import com.tobeto.rentacar.services.dtos.requests.color.UpdateColorRequest;
import com.tobeto.rentacar.services.dtos.requests.corporatecustomer.AddCorporateCustomerRequest;
import com.tobeto.rentacar.services.dtos.requests.corporatecustomer.UpdateCorporateCustomerRequest;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerListResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerResponse;

import java.util.List;

public interface CorporateCustomerService {
    List<GetCorporateCustomerListResponse> getAll();
    GetCorporateCustomerResponse getById(int id);
    void add(AddCorporateCustomerRequest addCorporateCustomerRequest);
    void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest);
    void delete(int id);

}
