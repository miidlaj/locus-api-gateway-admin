package com.midlaj.apiGatewayAdmin.service;

import com.midlaj.apiGatewayAdmin.payload.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

    ResponseEntity<?> signInAndReturnJWT(LoginRequest loginRequest);

}
