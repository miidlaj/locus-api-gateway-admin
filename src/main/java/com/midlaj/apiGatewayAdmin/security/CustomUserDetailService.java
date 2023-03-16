package com.midlaj.apiGatewayAdmin.security;

import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.service.UserService;
import com.midlaj.apiGatewayAdmin.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        Set<GrantedAuthority> authorities = SecurityUtils.convertToAuthority(user.getRoles());

        return UserPrincipal.builder()
                .user(user)
                .id(user.getId())
                .username(username)
                .name(user.getName())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
