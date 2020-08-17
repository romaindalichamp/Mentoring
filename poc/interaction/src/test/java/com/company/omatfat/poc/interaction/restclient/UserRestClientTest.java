package com.company.omatfat.poc.interaction.restclient;

import com.company.omatfat.poc.interaction.dto.UserDto;
import com.company.omatfat.poc.interaction.exception.MetierApiException;
import com.company.omatfat.poc.interaction.exception.UserException;
import com.company.omatfat.poc.interaction.service.api.UserServiceApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@SpringBootTest
class UserRestClientTest {

    @Autowired
    UserServiceApi userService;

    private UserDto DtoCreation(String firstName, String lastName, Integer old) {
        UserDto dtoCree = new UserDto();
        dtoCree.setFirstName(firstName);
        dtoCree.setLastName(lastName);
        dtoCree.setOld(old);
        return dtoCree;
    }


    @Test
    @DisplayName("GIVEN user dto ID WHEN get this user THEN give the user DTO info")
    void testGetUserDto() {
        //Given
        UserDto userDtoTest = DtoCreation("Ludwig", "Picot", 30);
        UserDto userDtoTestAdded = userService.addUserDto(userDtoTest);

        //When
        userService.getUserDto(userDtoTestAdded.getId());

        //Then
        Assertions.assertTrue(userDtoTest.getFirstName().equals(userDtoTestAdded.getFirstName()));

        //Finally
        userService.deleteUserDto(userDtoTestAdded.getId());
    }

    @Test
    @DisplayName("GIVEN user dto id WHEN get this user deleted THEN return error message")
    void testGetUserDtoNull() throws UserException {
        //Given
        UserDto userDtoTest = DtoCreation("Ludwig", "Picot", 30);
        UserDto userDtoTestAdded = userService.addUserDto(userDtoTest);

        //Then test added
        Assertions.assertTrue(userService.getUserDto(userDtoTestAdded.getId()).getFirstName().equals
                (userDtoTest.getFirstName()));

        //When
        userService.deleteUserDto(userDtoTestAdded.getId());

        //Then
        Assertions.assertThrows(UserException.class, () -> userService.getUserDto(userDtoTestAdded.getId()), "User not found");
    }

    @Test
    @DisplayName("GIVEN null user dto ID WHEN get this user THEN return error message")
    void testGetUserDtoReturnUser() {
        //Given
        UserDto userDtoTest = DtoCreation("Ludwig", "Picot", 30);
        UserDto userDtoTestAdded = userService.addUserDto(userDtoTest);

        //When
        userService.getUserDto(userDtoTestAdded.getId());

        //Then
        Assertions.assertTrue(userDtoTest.getFirstName().equals(userDtoTestAdded.getFirstName()));

        //Then
        Assertions.assertTrue(userService.getUserDto(userDtoTestAdded.getId()).getClass() == UserDto.class);

        //Finally
        userService.deleteUserDto(userDtoTestAdded.getId());
    }

    @Test
    @DisplayName("GIVEN list of user dto WHEN metho is called THEN check if a list of dto is returned")
    void getAllUserDto() {
        //Given
        UserDto userDtoTestOne = DtoCreation("Ludwig", "Picot", 30);
        UserDto userDtoTestTwo = DtoCreation("Ludwig", "Picot", 30);
        UserDto userDtoOneAdded = userService.addUserDto(userDtoTestOne);
        UserDto userDtoTwoAdded = userService.addUserDto(userDtoTestTwo);

        //When
        List<UserDto> listUser = userService.getAllUserDto();

        //Then
        Assertions.assertTrue(listUser.contains(userDtoOneAdded));
        Assertions.assertTrue(listUser.contains(userDtoTwoAdded));
        Assertions.assertTrue(userService.getAllUserDto().getClass() == listUser.getClass()); //deja teste dans le when en soit

        //Finally
        userService.deleteUserDto(userDtoOneAdded.getId());
        userService.deleteUserDto(userDtoTwoAdded.getId());
    }

    @Test
    @DisplayName("GIVEN empty list of user dto WHEN method is called THEN check if UserException is throwned")
    void getAllUserDtoArrayEmpty() throws UserException{
        //Given
        UserDto userDtoTestOne = DtoCreation("Ludwig", "Picot", 30);
        UserDto userDtoTestTwo = DtoCreation("Ludwigo", "Picote", 31);
        UserDto userDtoOneAdded = userService.addUserDto(userDtoTestOne);
        UserDto userDtoTwoAdded = userService.addUserDto(userDtoTestTwo);

        //When
        List<UserDto> listUser = userService.getAllUserDto();

        //Then added tests
        Assertions.assertTrue(listUser.contains(userDtoOneAdded));
        Assertions.assertTrue(listUser.contains(userDtoTwoAdded));

        //When
        userService.deleteUserDto(userDtoOneAdded.getId());
        userService.deleteUserDto(userDtoTwoAdded.getId());

        //Then
        Assertions.assertThrows(UserException.class, () -> userService.getAllUserDto(), "Could not contact the Metier API");
    }


}
