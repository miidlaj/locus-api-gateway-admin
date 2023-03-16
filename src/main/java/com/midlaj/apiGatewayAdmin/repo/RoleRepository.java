package com.midlaj.apiGatewayAdmin.repo;

import com.midlaj.apiGatewayAdmin.model.ERole;
import com.midlaj.apiGatewayAdmin.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
