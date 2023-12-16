package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.ModelMapperService;
import com.tobeto.rentacar.entities.User;
import com.tobeto.rentacar.repositories.UserRepository;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetUserListResponse> getAll() {
        List<User> users = this.userRepository.findAll();
        List<GetUserListResponse> responses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetUserListResponse.class)).collect(Collectors.toList());
        return responses;
    }

    @Override
    public GetUserResponse getById(int id) {
        User user = this.userRepository.findById(id).orElseThrow();
        GetUserResponse response = this.modelMapperService.forResponse()
                .map(user, GetUserResponse.class);

        return response;
    }

    @Override
    public void add(AddUserRequest addUserRequest) {
        User user=this.modelMapperService.forRequest().map(addUserRequest,User.class);
        this.userRepository.save(user);

    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        User user=this.modelMapperService.forRequest().map(updateUserRequest,User.class);
        this.userRepository.save(user);

    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);
    }
}
