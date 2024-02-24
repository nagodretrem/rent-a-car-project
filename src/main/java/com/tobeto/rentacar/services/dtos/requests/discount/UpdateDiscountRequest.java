package com.tobeto.rentacar.services.dtos.requests.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDiscountRequest {
    private int id;
    private String name;

    private double value;
}
