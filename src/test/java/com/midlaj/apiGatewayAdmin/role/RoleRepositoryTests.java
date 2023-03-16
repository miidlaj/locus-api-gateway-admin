package com.midlaj.apiGatewayAdmin.role;

import com.midlaj.apiGatewayAdmin.model.ERole;
import com.midlaj.apiGatewayAdmin.model.Role;
import com.midlaj.apiGatewayAdmin.repo.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleRepositoryTests {

    @Autowired
    private RoleRepository repo;


    @Test
    public void testCreateRestRoles(){
        Role roleAdmin = new Role(ERole.ROLE_ADMIN, "Full Access.");
        Role roleMod = new Role(ERole.ROLE_MODERATOR, "Limited Access");

        repo.saveAll(List.of(roleAdmin,roleMod));
    }
}
