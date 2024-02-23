package com.tobeto.rentacar.services.dtos.requests.car;

import com.tobeto.rentacar.entities.concretes.Available;
import com.tobeto.rentacar.entities.concretes.CarType;
import com.tobeto.rentacar.entities.concretes.FuelType;
import com.tobeto.rentacar.entities.concretes.TransmissionType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    @NotNull(message ="Car id cannot be empty" )
    @Positive(message = "Car id must be a positive number")
    private int id;

    @NotBlank(message = "Car plate number cannot be empty" )
    @Pattern(regexp = "(0[1-9]|[1-7][0-9]|8[01])((\\s?[a-zA-Z]\\s?)(\\d{4,5})|(\\s?[a-zA-Z]{2}\\s?)(\\d{3,4})|(\\s?[a-zA-Z]{3}\\s?)(\\d{2,3}))"
            ,message ="Invalid plate number")
    private String plate;

    @NotNull(message ="Car kilometer cannot be empty" )
    @Min(value = 0,message = "Car kilometer can not be less than 0!")
    private long kilometer;

    @NotBlank(message = "Car image path cannot be empty" )
    private String imagePath;

    @NotNull(message ="Car dailyPrice cannot be empty" )
    @DecimalMin(value = "0.0",inclusive = false,message ="Car dailyPrice can not be less than 0!" )
    private float dailyPrice;

    @NotNull(message = "Car findeks rate cannot be empty" )
    private short minFindeksRate;

    @NotNull(message = "Car type cannot be empty")
    private CarType carType;

    @NotNull(message = "Fuel type cannot be empty")
    private FuelType fuelType;

    @NotNull(message = "Transmission type cannot be empty")
    private TransmissionType transmissionType;

    @NotNull(message = "Car available cannot be empty")
    private Available available;

    @NotNull(message = "Car year cannot be empty" )
    @Min(value=2005,message = "Car year can not be less than 2005!")
    @Max(value = 2024,message = "Car year can not be greater than 2024!")
    private short modelYear;
    @NotNull(message ="Car modelId cannot be empty" )
    @Positive(message = "Car modelId must be a positive number")
    private int modelId;
    @NotNull(message ="Car colorId cannot be empty" )
    @Positive(message = "Car colorId must be a positive number")
    private int colorId;
}
