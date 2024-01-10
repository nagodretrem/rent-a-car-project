package com.tobeto.rentacar.services.dtos.requests.customer;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    @NotBlank(message = "Customer first name cannot be empty!")
    private String firstName;

    @NotBlank(message = "Customer last name cannot be empty!")
    private String lastName;

    @NotBlank(message = "Customer gsm cannot be empty!")
    @Pattern(regexp = "05\\d{9}", message = "Gsm must be a valid number. Like 05xxxxxxxxx")
    private String gsm;
    @NotNull
    private LocalDate birthDate;
}
