package com.tobeto.rentacar.services.dtos.responses.invoice;

import com.tobeto.rentacar.entities.concretes.Rental;
import com.tobeto.rentacar.services.dtos.responses.rental.GetRentalResponse;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetInvoiceListResponse {

    private int id;
    private String invoiceNo;

    private int taxRate;

    private short discountRate;

    private float totalPrice;

    private GetRentalResponse rentalResponse;
}
