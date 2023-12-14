package com.tobeto.rentacar.services.dtos.responses.model;

import com.tobeto.rentacar.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {
    private String name;
    private GetBrandResponse brandResponse;
}
