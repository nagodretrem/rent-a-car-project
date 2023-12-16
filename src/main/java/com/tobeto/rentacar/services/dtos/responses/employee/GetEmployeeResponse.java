package com.tobeto.rentacar.services.dtos.responses.employee;

import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {
    private double salary;

    private GetUserResponse userResponse;
}
