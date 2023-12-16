package com.tobeto.rentacar.services.dtos.requests.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int id;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int userId;
    @NotBlank(message = "Bu alan bos birakilamaz!")
    private String nationalityId;
}
