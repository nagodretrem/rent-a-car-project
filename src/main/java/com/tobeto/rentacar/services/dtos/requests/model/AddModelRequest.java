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
    @NotBlank(message = "Bu alan bos birakilamaz!")
    @Size(min = 2, max = 20, message = "Model ismi minimum 2 maximum 20 karakter olmalidir")
    private String name;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int brandId;
}
