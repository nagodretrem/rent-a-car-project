package com.tobeto.rentacar.services.dtos.responses.corporatecustomer;

import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCorporateCustomerListResponse {
    private int id;
    private String companyName;
    private String taxNo;
    private String corporateNumber;
    private String gsm;
    private GetUserResponse userResponse;
}
