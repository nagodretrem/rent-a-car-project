package com.tobeto.rentacar.services.dtos.requests.invoice;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddInvoiceRequest {

    @NotNull(message = "Invoice owner user cannot be empty!")
    private int ownerUser;


    @NotNull(message = "Invoice discount rate cannot be empty!")
    private short discountRate;


    @NotNull(message = "Invoice total price cannot be empty!")
    private float totalPrice;

    @NotNull(message = "Invoice rentalId cannot be empty!")
    private int rentalId;

}
