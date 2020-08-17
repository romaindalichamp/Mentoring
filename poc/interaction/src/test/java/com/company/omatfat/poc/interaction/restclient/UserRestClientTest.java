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
        UserDto user = new UserDto();
        user.setFirstName("Michel");
        user.setLastName("Drucker");
        user.setOld(64);

        // WHEN - addUserDto(user), getUserDto(user)
        UserDto addedUser = userRestClient.addUserDto(user);
        UserDto responseUser = userRestClient.getUserDto(addedUser.getId());

        // THEN - result
        Assertions.assertEquals(addedUser.getId(), responseUser.getId());
        Assertions.assertEquals(addedUser.getFirstName(), responseUser.getFirstName());
        Assertions.assertEquals(addedUser.getLastName(), responseUser.getLastName());
        Assertions.assertEquals(addedUser.getOld(), responseUser.getOld());

        // UserException when getting a user that doesn'T exist.
        Assertions.assertThrows(
                UserException.class,
                () -> userRestClient.getUserDto(99L));

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

        UserDto addedUserOne = userRestClient.addUserDto(userOne);
        UserDto addedUserTwo = userRestClient.addUserDto(userTwo);

        // WHEN getAllUserDto()
        List<UserDto> userDtos = userRestClient.getAllUserDto();
        System.out.println(userDtos);

        // THEN expected result
        Assertions.assertEquals(2, userDtos.size());
        Assertions.assertTrue(userDtos.contains(addedUserOne));
        Assertions.assertTrue(userDtos.contains(addedUserTwo));

        // FINALLY - clean
        userRestClient.deleteUserDto(addedUserOne.getId());
        userRestClient.deleteUserDto(addedUserTwo.getId());
    }


    @Test
    @DisplayName("GIVEN nothing, WHEN using getAllUserDto, THEN expect UserException")
    void getAllUserDtoWhenNullTest() {
        // GIVEN nothing
        // WHEN using getAllUserDto
        // THEN - expected result
        Assertions.assertThrows(
                UserException.class,
                () -> userRestClient.getAllUserDto());
    }


    @Test
    @DisplayName("GIVEN an old and a new user, WHEN updating old to new THEN i expect the correct result ")
    void updateUserDtoTest() {
        // GIVEN a fake user and a new user user
        UserDto oldUser = new UserDto(); // User we add to the database
        oldUser.setFirstName("Mickey");
        oldUser.setLastName("Mouse");
        oldUser.setOld(99);

        UserDto newUser = new UserDto(); // User that will replace oldUser
        newUser.setFirstName("Donald");
        newUser.setLastName("Duck");
        newUser.setOld(77);

        // WHEN updating old user to new user
        UserDto addedOldUser = userRestClient.addUserDto(oldUser);
        newUser.setId(addedOldUser.getId());
        UserDto updatedUser = userRestClient.updateUserDto(newUser);

        // THEN - expected result
        Assertions.assertEquals(addedOldUser.getId(), updatedUser.getId()); // Same Id as the old user
        Assertions.assertEquals(newUser.getFirstName(), updatedUser.getFirstName());
        Assertions.assertEquals(newUser.getLastName(), updatedUser.getLastName());
        Assertions.assertEquals(newUser.getOld(), updatedUser.getOld());

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
        UserDto createdUser = userRestClient.addUserDto(user);
        userRestClient.deleteUserDto(createdUser.getId());

        // THEN - expected result
        Long userId = createdUser.getId();
        Assertions.assertThrows(
                UserException.class,
                () -> userRestClient.getUserDto(userId));
        Assertions.assertThrows(
                UserException.class,
                () -> userRestClient.deleteUserDto(200L));
    }
}
