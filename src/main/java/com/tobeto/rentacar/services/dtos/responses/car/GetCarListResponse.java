package com.tobeto.rentacar.services.dtos.responses.car;

import com.tobeto.rentacar.services.dtos.responses.color.GetColorListResponse;
import com.tobeto.rentacar.services.dtos.responses.color.GetColorResponse;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.rentacar.services.dtos.responses.model.GetModelResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarListResponse {
    private int id;
    private String plate;
    private long kilometer;
    private float dailyPrice;
    private short modelYear;
    private short minFindeksRate;
    private String imagePath;
    private GetModelResponse model_id;
    private GetColorResponse color_id;
}
