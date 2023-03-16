package com.midlaj.apiGatewayAdmin.payload;

import com.midlaj.apiGatewayAdmin.model.Role;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {

    private String jwtToken;
    private String username;
    private String name;
    private Set<Role> roles;

}