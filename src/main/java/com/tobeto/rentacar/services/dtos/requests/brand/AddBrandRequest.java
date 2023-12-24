package com.tobeto.rentacar.services.dtos.requests.brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBrandRequest {
    @NotBlank(message = "Brand name cannot be empty")
    @Size(min = 2, max = 25, message = "Brand name must be between 2 and 25 characters long")
    private String name;

    @NotBlank(message = "Logo path cannot be empty")
    private String logoPath;

}


