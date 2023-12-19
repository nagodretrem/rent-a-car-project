package com.tobeto.rentacar.services.dtos.requests.brand;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequest {
    @NotNull(message = "Brand id cannot be empty")
    @Positive(message = "Brand id must be a positive number")
    private int id;
    @NotBlank(message = "Brand name cannot be empty")
    @Size(min = 2, max = 25, message = "Brand name must be between 2 and 25 characters long")
    private String name;
}
