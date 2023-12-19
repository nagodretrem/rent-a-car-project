package com.tobeto.rentacar.services.dtos.requests.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    @NotBlank(message = "Model name cannot be empty!")
    @Size(min = 2, max = 25, message = "Model name must be between 2 and 25 characters long!")
    private String name;
    @NotNull(message = "Brand id cannot be empty!")
    @Positive
    private int brandId;
}
