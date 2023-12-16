package com.tobeto.rentacar.services.dtos.requests.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull(message = "Bu alan bos birakilamaz!")
    private int id;
    @NotBlank(message = "Bu alan bos birakilamaz!")
    private String name;
    @NotBlank(message = "Bu alan bos birakilamaz!")
    private String surname;
    @NotBlank(message = "Bu alan bos birakilamaz!")
    private String email;
    @NotBlank(message = "Bu alan bos birakilamaz!")
    private String gsm;
}
