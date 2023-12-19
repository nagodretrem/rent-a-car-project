package com.tobeto.rentacar.services.dtos.requests.car;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCarRequest {

    @NotBlank(message = "Car plate number cannot be empty" )
    @Pattern(regexp = "(0[1-9]|[1-7][0-9]|8[01])((\\s?[a-zA-Z]\\s?)(\\d{4,5})|(\\s?[a-zA-Z]{2}\\s?)(\\d{3,4})|(\\s?[a-zA-Z]{3}\\s?)(\\d{2,3}))"
            ,message ="Invalid plate number")
    private String plateNumber;

    @NotNull(message ="Car kilometer cannot be empty" )
    @Min(value = 0,message = "Car kilometer can not be less than 0!")
    private int kilometer;

    @NotNull(message ="Car dailyPrice cannot be empty" )
    @DecimalMin(value = "0.0",inclusive = false,message ="Car dailyPrice can not be less than 0!" )
    private double dailyPrice;

    @NotNull(message = "Car year cannot be empty" )
    @Min(value=2005,message = "Car year can not be less than 2005!")
    @Max(value = 2024,message = "Car year can not be greater than 2024!")
    private int year;
    @NotNull(message ="Car modelId cannot be empty" )
    @Positive(message = "Car modelId must be a positive number")
    private int modelId;
    @NotNull(message ="Car colorId cannot be empty" )
    @Positive(message = "Car colorId must be a positive number")
    private int colorId;





}
