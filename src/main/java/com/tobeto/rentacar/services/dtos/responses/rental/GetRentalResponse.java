package com.tobeto.rentacar.services.dtos.responses.rental;

import com.tobeto.rentacar.services.dtos.responses.car.GetCarResponse;
import com.tobeto.rentacar.services.dtos.responses.corporatecustomer.GetCorporateCustomerResponse;
import com.tobeto.rentacar.services.dtos.responses.customer.GetCustomerResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetRentalResponse {

    private int id;

    private LocalDate startDate;

    private LocalDate endDate;

    private LocalDate returnDate;

    private int startKilometer;

    private int endKilometer;


    private GetCarResponse carResponse;

    private GetUserResponse getUserResponse;

}
