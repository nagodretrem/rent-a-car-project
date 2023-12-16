package com.tobeto.rentacar.services.dtos.responses.employee;


import com.tobeto.rentacar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeListResponse {

    private int id;

    private double salary;

    private GetUserResponse userResponse;
}
