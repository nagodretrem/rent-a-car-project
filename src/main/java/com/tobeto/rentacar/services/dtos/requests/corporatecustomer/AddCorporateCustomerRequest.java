package com.tobeto.rentacar.services.dtos.requests.corporatecustomer;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCorporateCustomerRequest {

    @NotBlank(message = "CorporateCustomer company name cannot be empty!")
    @Size(min = 2, max = 25, message = "CorporateCustomer name must be between 2 and 25 characters long!")
    private String companyName;
    @NotBlank(message = "CorporateCustomer taxs no cannot be empty!")
    private String taxNo;
    @NotBlank(message = "CorporateCustomer corporateNumber cannot be empty!")
    private String corporateNumber;
    @NotBlank(message = "CorporateCustomer gsm cannot be empty!")
    private String gsm;
    private int userId;
}
