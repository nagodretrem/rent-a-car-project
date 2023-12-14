package com.tobeto.rentacar.services.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private int id;
    private String plateNumber;
    private int kilometer;
    private double dailyPrice;
    private int year;
}
