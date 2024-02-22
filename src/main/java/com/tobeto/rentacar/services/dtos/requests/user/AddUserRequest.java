package com.tobeto.rentacar.services.dtos.requests.user;

import com.tobeto.rentacar.entities.concretes.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserRequest {

    @NotBlank(message = "User email cannot be empty!")
    @Email(message = "User email must be a valid email address.")
    private String email;
    @NotBlank(message = "User password cannot be empty!")
    private String password;




}
