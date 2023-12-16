package com.tobeto.rentacar.controllers;

import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentacar.services.dtos.requests.user.UpdateUserRequest;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UsersController {
    private UserService userService;

    @GetMapping()
    public List<GetUserListResponse> getAll(){
        return userService.getAll();
    }
    @GetMapping({"/{id}"})
    public GetUserResponse getById(@PathVariable int id){
        return userService.getById(id);
    }
    @PostMapping()
    public void add(@RequestBody @Valid AddUserRequest addUserRequest){
        this.userService.add(addUserRequest);
    }

    @PutMapping()
    public void update(@RequestBody @Valid UpdateUserRequest updateUserRequest){
        this.userService.update(updateUserRequest);
    }

    @DeleteMapping({"/{id}"})
    public void delete(@PathVariable int id){
        this.userService.delete(id);
    }
}
