package com.tobeto.rentacar.services.dtos.requests.employee;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest {

    @NotNull(message = "Bu alan bos birakilamaz!")
    private double salary;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int userId;
}
