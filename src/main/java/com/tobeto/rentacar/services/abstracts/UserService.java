package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserIdResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<GetUserListResponse> getAll();

    GetUserResponse getById(int id);

    GetUserIdResponse getByEmail(String email);

    void update(UpdateUserRequest updateUserRequest);

    void delete(int id);

    boolean existsById(int id);

    void add(User user);
}
