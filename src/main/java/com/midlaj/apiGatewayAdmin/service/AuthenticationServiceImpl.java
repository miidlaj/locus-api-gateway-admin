package com.midlaj.apiGatewayAdmin.service;

import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.payload.AuthResponse;
import com.midlaj.apiGatewayAdmin.payload.LoginRequest;
import com.midlaj.apiGatewayAdmin.security.UserPrincipal;
import com.midlaj.apiGatewayAdmin.security.jwt.JwtProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public ResponseEntity<?> signInAndReturnJWT(LoginRequest loginRequest) {


        Authentication authentication;

        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (DisabledException e) {
            log.error("User is disabled");
            return new ResponseEntity<>("User is disabled", HttpStatus.NOT_ACCEPTABLE);
        } catch (BadCredentialsException e) {
            log.error("Bad credentials");
            return new ResponseEntity<>("Bad Credentials", HttpStatus.LOCKED);
        }


        UserPrincipal userPrinciple = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrinciple);

        User user = userPrinciple.getUser();

        return ResponseEntity.ok(AuthResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .jwtToken(jwt)
                .roles(user.getRoles())
                .build());
    }
}
