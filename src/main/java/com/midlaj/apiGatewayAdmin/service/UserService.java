package com.midlaj.apiGatewayAdmin.service;


import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.payload.SignUpRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    Optional<User> findByUsername(String username);

    User saveUser(SignUpRequest signUpRequest);
}
