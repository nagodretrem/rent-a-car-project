package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.Brand;
import com.tobeto.rentacar.repositories.BrandRepository;
import com.tobeto.rentacar.services.abstracts.BrandService;
import com.tobeto.rentacar.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.rentacar.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands=this.brandRepository.findAll();
        List<GetBrandListResponse> response=brands.stream().
                map(brand ->this.modelMapperService.forResponse().
                        map(brand,GetBrandListResponse.class)).collect(Collectors.toList());
        return response;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand=this.brandRepository.findById(id).orElseThrow();
        GetBrandResponse response=this.modelMapperService.forResponse().
                map(brand,GetBrandResponse.class);
        return response;
    }

    @Override
    public void add(AddBrandRequest addBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(addBrandRequest,Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);


    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }
}
