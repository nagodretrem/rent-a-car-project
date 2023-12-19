package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @NotNull(message = "Rental id cannot be empty!")
    @Positive(message = "Rental id must be a positive number.")
    private int id;

    @NotNull(message = "Rental startDate cannot be empty!")
    private LocalDate startDate;

    @NotNull(message = "Rental endDate cannot be empty!")
    private LocalDate endDate;

    @NotNull(message = "Rental discount cannot be empty!")
    @Positive(message = "Rental discount must be a positive number.")
    private double discount;

    @NotNull(message = "Rental carId cannot be empty!")
    private int carId;

    @NotNull(message = "Rental customerId cannot be empty!")
    private int customerId;

    @NotNull(message = "Rental employeeId cannot be empty!")
    private int employeeId;

    private LocalDate returnDate;
    private int endKilometer;

}
