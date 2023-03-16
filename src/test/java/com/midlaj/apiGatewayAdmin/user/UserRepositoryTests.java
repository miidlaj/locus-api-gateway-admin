package com.midlaj.apiGatewayAdmin.user;

import com.midlaj.apiGatewayAdmin.model.ERole;
import com.midlaj.apiGatewayAdmin.model.Role;
import com.midlaj.apiGatewayAdmin.model.User;
import com.midlaj.apiGatewayAdmin.repo.RoleRepository;
import com.midlaj.apiGatewayAdmin.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    @Test
//    public void testCreateUsers(){
//
//        User user = new User();
//
//        user.setUsername("test@gmail.com");
//        user.setPassword(passwordEncoder.encode("12345678"));
//        user.setName("Muhammed Test");
//        Set<Role> roles = Set.of(roleRepository.findByName(ERole.ROLE_ADMIN).get());
//        user.setRoles(roles);
//
//        repository.save(user);
//    }
}
