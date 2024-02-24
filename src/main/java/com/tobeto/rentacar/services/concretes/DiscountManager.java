package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.Discount;
import com.tobeto.rentacar.repositories.DiscountRepository;
import com.tobeto.rentacar.services.abstracts.DiscountService;
import com.tobeto.rentacar.services.dtos.requests.discount.AddDiscountRequest;
import com.tobeto.rentacar.services.dtos.requests.discount.UpdateDiscountRequest;
import com.tobeto.rentacar.services.dtos.responses.dicount.GetDiscountListResponse;
import com.tobeto.rentacar.services.dtos.responses.dicount.GetDiscountResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DiscountManager implements DiscountService {

    private final DiscountRepository discountRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetDiscountListResponse> getAll() {

        List<Discount> discounts = this.discountRepository.findAll();

        return discounts
                .stream()
                .map(discount -> this.modelMapperService
                        .forResponse()
                        .map(discount, GetDiscountListResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetDiscountResponse getByCode(String code) {

        Discount discount = this.discountRepository.findByName(code).orElseThrow();

        return this.modelMapperService
                .forResponse()
                .map(discount, GetDiscountResponse.class);
    }


    @Override
    public void add(AddDiscountRequest addDiscountRequest) {

        Discount discount = this.modelMapperService
                .forRequest()
                .map(addDiscountRequest, Discount.class);
        this.discountRepository.save(discount);

    }

    @Override
    public void update(UpdateDiscountRequest updateDiscountRequest) {
        Discount discount = this.modelMapperService
                .forRequest()
                .map(updateDiscountRequest, Discount.class);
        this.discountRepository.save(discount);
    }

    @Override
    public void delete(int id) {

        this.discountRepository.deleteById(id);

    }
}
