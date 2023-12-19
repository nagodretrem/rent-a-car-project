package com.tobeto.rentacar.services.dtos.requests.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    @NotNull(message = "Model id cannot be empty!")
    @Positive(message = "Model id must be a positive number.")
    private int id;
    @NotBlank(message = "Model name cannot be empty!")
    @Size(min = 2, max = 25, message = "Model name must be between 2 and 25 characters long!")
    private String name;

    @NotNull(message = "Brand id cannot be empty!")
    @Positive
    private int brandId;
}
