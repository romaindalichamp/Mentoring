package com.company.omatfat.poc.interaction.service.impl;

import com.company.omatfat.poc.interaction.dto.UserDto;
import com.company.omatfat.poc.interaction.service.api.UserServiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@SpringBootTest
public class UserServiceImplTest {
    /*
        /!\ ----- Test name = ClassNameTest                                /!\
        /!\ ----- SERVICES are the only revelent classes to be Unit Test   /!\
        /!\ ----- PUBLIC Methods are to test ONLY                          /!\
     */

    @Autowired
    UserServiceApi interactionService;

    @Test
    @DisplayName("GIVEN fake InteractionDto WHEN i get by id THEN i expect the correct infos")
    void getInteractionEntity() {
        // GIVEN - Fake Data
        UserDto userDto = new UserDto();
        userDto.setFirstName("Anthony");
        userDto.setLastName("Stark");
        userDto.setOld(50);
        UserDto myInteractionDtoCreated = interactionService.addUserDto(userDto);

        // WHEN - method to test
        UserDto myResult = interactionService.getUserDto(
                myInteractionDtoCreated.getId()
        );

        // THEN - Expected Result
        Assertions.assertTrue(myResult.getFirstName().equals("Anthony"));
        Assertions.assertTrue(myResult.getLastName().equals("Stark"));
        Assertions.assertTrue(myResult.getOld().equals(50));

        // FINALLY - clean
        interactionService.deleteUserDto(myInteractionDtoCreated.getId());
    }
}
