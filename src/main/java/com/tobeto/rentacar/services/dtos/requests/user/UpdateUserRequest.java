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
    @NotBlank(message = "User name cannot be empty!")
    private String name;
    @NotBlank(message = "User surname cannot be empty!")
    private String surname;
    @NotBlank(message = "User email cannot be empty!")
    @Email(message = "User email must be a valid email address.")
    private String email;
    @NotBlank(message = "User gsm cannot be empty!")
    @Pattern(regexp = "05\\d{9}", message = "Gsm must be a valid number. Like 05xxxxxxxxx")
    private String gsm;


}