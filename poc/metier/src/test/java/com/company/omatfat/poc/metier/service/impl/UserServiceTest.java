package com.company.omatfat.poc.metier.service.impl;

import com.company.omatfat.poc.metier.entity.UserEntity;
import com.company.omatfat.poc.metier.service.api.UserServiceApi;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 * TODO: Write Description
 */
@SpringBootTest
public class UserServiceTest {
    /*
        /!\ ----- Test name = ClassNameTest                                /!\
        /!\ ----- SERVICES are the only revelent classes to be Unit Test   /!\
        /!\ ----- PUBLIC Methods are to test ONLY                          /!\
     */

    @Autowired
    UserServiceApi userService;

    @Test
    @DisplayName("GIVEN fake UserEntity WHEN i get by id THEN i expect the correct infos")
    void getUserEntityTest() {
        // GIVEN - Fake Data
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Anthony");
        userEntity.setLastName("Stark");
        userEntity.setOld(50);
        UserEntity myUserEntityCreated = userService.addUserEntity(userEntity);

        // WHEN - method to test
        Optional<UserEntity> myResult = userService.getUserEntity(
                myUserEntityCreated.getId()
        );

        // THEN - Expected Result
        Assertions.assertTrue(myResult.get().getFirstName().equals("Anthony"));
        Assertions.assertTrue(myResult.get().getLastName().equals("Stark"));
        Assertions.assertTrue(myResult.get().getOld().equals(50));

        // FINALLY - clean
        userService.deleteUserEntity(myUserEntityCreated.getId());
    }

    @Test
    @DisplayName("GIVEN fake UserEntity WHEN i get by id THEN i expect the correct infos")
    void getInteractionEntity() {
        // GIVEN - Fake Data
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Anthony");
        userEntity.setLastName("Stark");
        userEntity.setOld(50);
        UserEntity myUserEntityCreated = userService.addUserEntity(userEntity);

        // WHEN - method to test
        Optional<UserEntity> myResult = userService.getUserEntity(
                myUserEntityCreated.getId()
        );

        // THEN - Expected Result
        Assertions.assertTrue(myResult.get().getFirstName().equals("Anthony"));
        Assertions.assertTrue(myResult.get().getLastName().equals("Stark"));
        Assertions.assertTrue(myResult.get().getOld().equals(50));

        // FINALLY - clean
        userService.deleteUserEntity(myUserEntityCreated.getId());
    }
}
