package com.tobeto.rentacar.services.dtos.requests.employee;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {

    @NotNull(message = "Employee salary cannot be empty!")
    @Positive(message = "Employee salary must be a positive number.")
    private double salary;
    @NotNull(message = "Employee userId cannot be empty!")
    @Positive(message = "Employee userId must be a positive number.")
    private int userId;
}
