package com.tobeto.rentacar.services.dtos.responses.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserListResponse {

    private int id;

    private String name;

    private String surname;

    private String email;

    private String gsm;

}
