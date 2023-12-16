package com.tobeto.rentacar.services.dtos.responses.customer;

import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {
    private String nationalityId;

    private GetUserResponse getUserResponse;
}
