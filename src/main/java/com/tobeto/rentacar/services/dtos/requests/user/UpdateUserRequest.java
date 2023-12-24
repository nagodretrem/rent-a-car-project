package com.tobeto.rentacar.services.dtos.requests.user;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull(message = "User id cannot be empty!")
    @Positive(message = "Id must be a positive number.")
    private int id;
    @NotBlank(message = "User password cannot be empty!")
    private String password;
    @NotBlank(message = "User adaress cannot be empty!")
    private String address;
    @NotBlank(message = "User email cannot be empty!")
    @Email(message = "User email must be a valid email address.")
    private String email;
}