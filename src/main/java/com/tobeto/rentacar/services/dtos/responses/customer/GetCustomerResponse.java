package com.tobeto.rentacar.services.dtos.responses.customer;

import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerResponse {

    private String nationalityId;

    private String firstName;

    private String lastName;

    private String gsm;

    private LocalDate birthDate;

    private String address;

    private GetUserResponse getUserResponse;
}
