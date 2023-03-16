package com.midlaj.apiGatewayAdmin.contoller;

import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.payload.LoginRequest;
import com.midlaj.apiGatewayAdmin.payload.SignUpRequest;
import com.midlaj.apiGatewayAdmin.service.AuthenticationService;
import com.midlaj.apiGatewayAdmin.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    private final UserServiceImpl userService;

    public AuthenticationController(AuthenticationService authenticationService, UserServiceImpl userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest loginRequest) {
        log.info("Inside the signIn method in AuthController");

        return authenticationService.signInAndReturnJWT(loginRequest);
    }

    @PostMapping("create")
    public ResponseEntity<?> createUser(@RequestBody SignUpRequest signUpRequest) {
        log.info("Inside the signIn method in AuthController");

        User savedUser = userService.saveUser(signUpRequest);

        return ResponseEntity.ok(savedUser);
    }



}
