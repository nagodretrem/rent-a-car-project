package com.tobeto.rentacar.services.dtos.responses.invoice;

import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetInvoiceResponse {
    private int id;

    private int ownerUser;

    private short discountRate;

    private float totalPrice;

    private GetRentalResponse rentalResponse;
}
