package com.tobeto.rentacar.services.dtos.responses.model;

import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelListResponse {
    private int id;
    private String name;
    private GetBrandResponse brandResponse;
}
