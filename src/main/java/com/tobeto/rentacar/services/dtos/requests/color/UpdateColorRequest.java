package com.tobeto.rentacar.services.dtos.requests.color;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateColorRequest {
    @NotNull(message = "Color id cannot be empty!")
    @Positive(message = "Color id must be a positive number.")
    private int id;
    @NotBlank(message = "Color name cannot be empty!")
    @Size(min = 2, max = 25, message = "Color name must be between 2 and 25 characters long!")
    private String name;
}
