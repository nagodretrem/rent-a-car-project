package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.discount.AddDiscountRequest;
import com.tobeto.rentacar.services.dtos.requests.discount.UpdateDiscountRequest;
import com.tobeto.rentacar.services.dtos.responses.dicount.GetDiscountListResponse;
import com.tobeto.rentacar.services.dtos.responses.dicount.GetDiscountResponse;

import java.util.List;

public interface DiscountService {

    List<GetDiscountListResponse> getAll();


    GetDiscountResponse getByCode(String code);

    void add(AddDiscountRequest addDiscountRequest);

    void update(UpdateDiscountRequest updateDiscountRequest);

    void delete(int id);

}
