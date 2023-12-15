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
    @NotBlank(message = "Bu alan bos birakilamaz!")
    @Size(min = 2, max = 20, message = "Marka ismi en az 2 en fazla 20 karakter olmalidir!")
    private String name;
}
