package com.tobeto.rentacar.services.dtos.requests.color;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddColorRequest {
    @NotBlank(message = "Color name cannot be empty!")
    @Size(min = 2, max = 25, message = "Color name must be between 2 and 25 characters long!")
    private String name;
}
