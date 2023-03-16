package com.midlaj.apiGatewayAdmin.contoller;

import com.midlaj.apiGatewayAdmin.exception.ResourceNotFoundException;
import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.repo.UserRepository;
import com.midlaj.apiGatewayAdmin.security.CurrentUser;
import com.midlaj.apiGatewayAdmin.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("test")
    public ResponseEntity<?> test() {

        return ResponseEntity.ok("Authenticated");
    }


    @GetMapping("/user/me")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

}
