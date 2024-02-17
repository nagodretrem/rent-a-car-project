package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.utilities.mappers.services.ModelMapperService;
import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.repositories.UserRepository;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;
import com.tobeto.rentacar.services.dtos.responses.user.GetUserListResponse;
import com.tobeto.rentacar.services.rules.UserBusinessRules;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserManagerTest
{
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;
    @Mock
    private AddUserRequest addUserRequest;

    @Mock
    private UserBusinessRules userBusinessRules;
    @Mock
    private ModelMapperService modelMapperService;
    @Mock
    private User user;
    @Mock
    private List<User> users;

    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.openMocks(this);
        userService = new UserManager(userRepository,modelMapperService, userBusinessRules);
        addUserRequest = new AddUserRequest();
        users = new ArrayList<>();
        user = new User();
    }
    @AfterEach
    void tearDown()
    {

    }

    @Test
    void isUserDuplicated()
    {
        String eMail = "eren@gmail.com";
        user.setEmail(eMail);
        addUserRequest.setEmail(eMail);
        Mockito.when(userRepository.existsByEmail(eMail)).thenReturn(true);
        try {
            userService.add(user);
            assert true;
        } catch (RuntimeException e) {
            assert false;
        }
    }

    @Test
    void isGetAllSuccessfullyRun() {
        Mockito.when(userRepository.findAll()).thenReturn(users);
        List<GetUserListResponse> result = userService.getAll();
        assertEquals(users, result);
    }

    @Test
    void isGetByIdSuccesfullyRun()
    {
        //
    }
}
