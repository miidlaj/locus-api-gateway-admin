package com.midlaj.apiGatewayAdmin.service;

import com.midlaj.apiGatewayAdmin.model.ERole;
import com.midlaj.apiGatewayAdmin.model.Role;
import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.payload.SignUpRequest;
import com.midlaj.apiGatewayAdmin.repo.RoleRepository;
import com.midlaj.apiGatewayAdmin.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setName(signUpRequest.getName());

        Set<Role> roles = Set.of(roleRepository.findByName(ERole.ROLE_ADMIN).get());
        user.setRoles(roles);

        return userRepository.save(user);
    }
}
