package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.auth.LoginRequest;
import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;

public interface AuthService {
    void register(AddUserRequest addUserRequest);
    String login(LoginRequest loginRequest);
}
