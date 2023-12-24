package com.tobeto.rentacar.services.dtos.requests.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddUserRequest {

    @NotBlank(message = "User password cannot be empty!")
    private String password;
    @NotBlank(message = "User adaress cannot be empty!")
    private String address;
    @NotBlank(message = "User email cannot be empty!")
    @Email(message = "User email must be a valid email address.")
    private String email;

}
