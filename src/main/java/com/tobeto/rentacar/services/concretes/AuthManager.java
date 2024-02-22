package com.tobeto.rentacar.services.concretes;

import com.tobeto.rentacar.core.services.JwtService;
import com.tobeto.rentacar.entities.concretes.Role;
import com.tobeto.rentacar.entities.concretes.User;
import com.tobeto.rentacar.services.abstracts.AuthService;
import com.tobeto.rentacar.services.abstracts.UserService;
import com.tobeto.rentacar.services.dtos.requests.auth.LoginRequest;
import com.tobeto.rentacar.services.dtos.requests.user.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
@AllArgsConstructor
public class AuthManager implements AuthService {
    private  final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public void register(AddUserRequest addUserRequest) {

        User user = User.builder()
                .email(addUserRequest.getEmail())
                .password(passwordEncoder.encode(addUserRequest.getPassword()))
                .build();
        user.setAuthorities(Arrays.asList(Role.valueOf("USER")));
        userService.add(user);

    }

    @Override
    public String login(LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.
                        authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                        loginRequest.getPassword()));
        if(authentication.isAuthenticated())
        {



            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            // jwt oluştur.
            Map<String,Object> claims = new HashMap<>();
            claims.put("role", userDetails.getAuthorities());
            claims.put("id",userService.getByEmail(loginRequest.getEmail()).getId());



            return jwtService.generateToken(loginRequest.getEmail(), claims);
        }
        throw new RuntimeException("Bilgiler hatalı");
    }
}
