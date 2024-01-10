package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddRentalRequest {


    @NotNull(message = "Rental startDate cannot be empty!")
    @FutureOrPresent(message = "Start date must not be before today!")
    private LocalDate startDate;

    @NotNull(message = "Rental endDate cannot be empty!")
    @Future(message = "End date must be future date!")
    private LocalDate endDate;

    @NotNull(message = "Rental discount cannot be empty!")
    private double discount;

    @NotNull(message = "Rental carId cannot be empty!")
    private int carId;

    @NotNull(message = "Rental userId cannot be empty!")
    private int userId;




}
