package com.tobeto.rentacar.services.dtos.responses.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetColorResponse {
    private String name;
    private String code;
}
