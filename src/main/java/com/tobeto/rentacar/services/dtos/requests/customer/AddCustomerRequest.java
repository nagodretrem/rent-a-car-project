package com.tobeto.rentacar.services.dtos.requests.customer;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCustomerRequest {


    @NotNull(message = "Employee userId cannot be empty!")
    @Positive(message = "Employee userId must be a positive number.")
    private int userId;
    @NotBlank(message = "Customer nationalityId cannot be empty!")
    @Pattern(regexp = "\\d{11}", message = "NationalityId must be a 11-digit number.")
    private String nationalityId;
}
