package com.tobeto.rentacar.services.dtos.requests.car;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {
    private String plateNumber;
    private int kilometer;
    private double dailyPrice;
    private int year;
    private int model_id;
    private int color_id;





}
