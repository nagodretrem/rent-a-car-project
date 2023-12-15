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
    @NotBlank(message = "Bu alan bos birakilamaz!")
    @Size(min = 2, max = 15, message = "Renk ismi en az 2 en fazla 15 karakter olmalidir!")
    private String name;
}
