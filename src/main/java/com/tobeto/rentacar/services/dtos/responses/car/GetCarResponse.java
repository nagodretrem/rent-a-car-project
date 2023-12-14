package com.tobeto.rentacar.services.dtos.responses.car;

import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponse {
    private String plateNumber;
    private int kilometer;
    private double dailyPrice;
    private int year;
    private GetModelResponse model_id;
    private GetColorResponse color_id;
}
