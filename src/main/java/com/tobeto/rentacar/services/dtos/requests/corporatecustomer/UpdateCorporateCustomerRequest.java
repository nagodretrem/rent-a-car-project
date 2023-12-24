package com.tobeto.rentacar.services.dtos.requests.corporatecustomer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCorporateCustomerRequest {
    @NotNull(message = "Corporate customer id cannot be empty!")
    @Positive(message = "Corporate customer id must be a positive number.")
    private int id;
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
