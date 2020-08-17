package com.company.omatfat.poc.interaction.restclient;

import com.company.omatfat.poc.interaction.dto.UserDto;
import com.company.omatfat.poc.interaction.exception.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@SpringBootTest
class UserRestClientTest {

    @Autowired
    UserRestClient userRestClient;

    @Test
    @DisplayName("GIVEN a fake user WHEN using addUserDto and getUserDto THEN I expect the correct info.")
    void addAndGetUserDtoTest() {
        // GIVEN fake user
        String firstName = "Michel";
        String lastName = "Drucker";
        int old = 62;

        UserDto user = new UserDto();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setOld(old);

        // WHEN - addUserDto(user), getUserDto(user)
        user = userRestClient.addUserDto(user);
        UserDto responseUser = userRestClient.getUserDto(user.getId());

        // THEN - result
        Assertions.assertEquals(user.getId(), responseUser.getId());
        Assertions.assertEquals(firstName, responseUser.getFirstName());
        Assertions.assertEquals(lastName, responseUser.getLastName());
        Assertions.assertEquals(old, responseUser.getOld());

        // FINALLY - clean
        userRestClient.deleteUserDto(responseUser.getId());

    }

    @Test
    @DisplayName("GIVEN two fake users WHEN using getAllUserDto THEN I expect the correct info.")
    void getAllUserDtoTest() {
        // GIVEN two fakes users
        UserDto userOne = new UserDto();
        userOne.setFirstName("Rick");
        userOne.setLastName("Sanchez");
        userOne.setOld(65);

        UserDto userTwo = new UserDto();
        userTwo.setFirstName("Morty");
        userTwo.setLastName("Smith");
        userTwo.setOld(14);

        userOne = userRestClient.addUserDto(userOne);
        userTwo = userRestClient.addUserDto(userTwo);

        // WHEN getAllUserDto()
        List<UserDto> userDtos = userRestClient.getAllUserDto();

        // THEN expected result
        Assertions.assertEquals(2, userDtos.size());
        Assertions.assertTrue(userDtos.contains(userOne));
        Assertions.assertTrue(userDtos.contains(userTwo));

        // FINALLY - clean
        userRestClient.deleteUserDto(userOne.getId());
        userRestClient.deleteUserDto(userTwo.getId());
    }


    @Test
    @DisplayName("GIVEN an old and a new user, WHEN updating old to new THEN i expect the correct result ")
    void updateUserDtoTest() {
        // GIVEN a fake user and a new user user
        UserDto oldUser = new UserDto();
        oldUser.setFirstName("Mickey");
        oldUser.setLastName("Mouse");
        oldUser.setOld(99);


        String newUserFirstName = "Donald";
        String newUserLastName = "Duck";
        int newUserOld = 77;

        UserDto newUser = new UserDto();
        newUser.setFirstName(newUserFirstName);
        newUser.setLastName(newUserLastName);
        newUser.setOld(newUserOld);

        // WHEN updating old user to new user
        oldUser = userRestClient.addUserDto(oldUser);
        newUser.setId(oldUser.getId());
        newUser = userRestClient.updateUserDto(newUser);
        UserDto updatedUser = userRestClient.getUserDto(newUser.getId());

        // THEN - expected result
        Assertions.assertEquals(newUserFirstName, updatedUser.getFirstName());
        Assertions.assertEquals(newUserLastName, updatedUser.getLastName());
        Assertions.assertEquals(newUserOld, updatedUser.getOld());

        // FINALLY - clean
        userRestClient.deleteUserDto(updatedUser.getId());
    }


    @Test
    @DisplayName("GIVEN a fake user, WHEN adding the user and deleting it THEN  I expect the correct result.")
    void deleteUserDtoTest() {
        // GIVEN a fake user
        UserDto user = new UserDto();
        user.setFirstName("Bruce");
        user.setLastName("Wayne");
        user.setOld(46);

        // WHEN adding then deleting the user
        user = userRestClient.addUserDto(user);
        userRestClient.deleteUserDto(user.getId());

        // THEN - expected result
        Long userId = user.getId();
        Assertions.assertThrows(
                UserException.class,
                () -> userRestClient.getUserDto(userId));
    }
}
