package com.tobeto.rentacar.services.dtos.requests.rental;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRentalRequest {

    @NotNull(message = "Bu alan bos birakilamaz!")
    private int id;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private LocalDate startDate;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private LocalDate endDate;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int startKilometer;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private double totalPrice;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private double discount;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int carId;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int customerId;
    @NotNull(message = "Bu alan bos birakilamaz!")
    private int employeeId;
    private LocalDate returnDate;
    private int endKilometer;

}
