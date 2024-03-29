package com.tobeto.rentacar.services.dtos.responses.dicount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDiscountListResponse {

    private int id;
    private String name;
    private double value;
}
