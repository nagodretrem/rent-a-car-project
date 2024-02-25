package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.dtos.requests.auth.LoginRequest;
import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;

public interface AuthService {
    User register(AddUserRequest addUserRequest);
    String login(LoginRequest loginRequest);
}
