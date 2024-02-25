package com.tobeto.rentacar.services.dtos.requests.invoice;

import com.tobeto.rentacar.entities.concretes.Rental;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceRequest {
    @NotNull(message = "Invoice id cannot be empty!")
    @Positive(message = "Invoice id must be a positive number.")
    private int id;

    @NotNull(message = "Invoice owner user cannot be empty!")
    private int ownerUser;

    @NotNull(message = "Invoice discount rate cannot be empty!")
    private short discountRate;


    @NotNull(message = "Invoice total price cannot be empty!")
    private float totalPrice;

    @NotNull(message = "Invoice rentalId cannot be empty!")
    private int rentalId;
}
