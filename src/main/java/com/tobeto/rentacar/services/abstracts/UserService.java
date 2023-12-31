package com.tobeto.rentacar.services.abstracts;

import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;

import java.util.List;

public interface UserService {
    List<GetUserListResponse> getAll();
    GetUserResponse getById(int id);
    void add(AddUserRequest addUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    void delete(int id);

    boolean existsById(int id);
}
