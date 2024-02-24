package com.tobeto.rentacar.services.dtos.requests.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDiscountRequest {
    private String name;
    private double value;
}
