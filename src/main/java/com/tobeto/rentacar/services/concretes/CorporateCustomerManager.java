package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Car;
import com.tobeto.rentacar.entities.concretes.Color;
import com.tobeto.rentacar.entities.concretes.CorporateCustomer;
import com.tobeto.rentacar.repositories.CorporateCustomerRepository;
import com.tobeto.rentacar.services.abstracts.CorporateCustomerService;
import com.tobeto.rentacar.services.dtos.requests.corporatecustomer.AddCorporateCustomerRequest;
import com.tobeto.rentacar.services.dtos.requests.corporatecustomer.UpdateCorporateCustomerRequest;
import com.tobeto.rentacar.services.dtos.responses.car.GetCarListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerListResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CorporateCustomerManager implements CorporateCustomerService  {
    private final CorporateCustomerRepository corporateCustomerRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetCorporateCustomerListResponse> getAll() {
        List<CorporateCustomer> corporateCustomers= this.corporateCustomerRepository.findAll();
        List<GetCorporateCustomerListResponse> response= corporateCustomers
        .stream()
                .map(corporateCustomer -> this.modelMapperService. forResponse()
                        .map(corporateCustomer,GetCorporateCustomerListResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public GetCorporateCustomerResponse getById(int id) {
       CorporateCustomer corporateCustomer=this.corporateCustomerRepository.findById(id).orElseThrow();
        GetCorporateCustomerResponse response=this.modelMapperService.forResponse()
                .map(corporateCustomer,GetCorporateCustomerResponse.class);
        return response;

    }

    @Override
    public void add(AddCorporateCustomerRequest addCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer=this.modelMapperService.forRequest().map(addCorporateCustomerRequest,CorporateCustomer.class);
        this.corporateCustomerRepository.save(corporateCustomer);

    }

    @Override
    public void update(UpdateCorporateCustomerRequest updateCorporateCustomerRequest) {
        CorporateCustomer corporateCustomer=this.modelMapperService.forRequest().map(updateCorporateCustomerRequest,CorporateCustomer.class);
        this.corporateCustomerRepository.save(corporateCustomer);

    }

    @Override
    public void delete(int id) {
        this.corporateCustomerRepository.deleteById(id);

    }
}
