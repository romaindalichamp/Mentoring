package com.company.omatfat.poc.interaction.controller;

import com.company.omatfat.poc.interaction.dto.UserDto;
import com.company.omatfat.poc.interaction.service.api.UserServiceApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
//@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    // @Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    // Important: "final" pour que Spring fasse l'injection de dépendance dans le constructeur
    // permet d'avoir les exceptions dès l'initialisation de la classe
    private final UserServiceApi userServiceInterface;

    @GetMapping("{id}") // GET http://----/users/1
    public UserDto getUserDto(@PathVariable Long id) {
        return userServiceInterface.getUserDto(id);
    }

    @GetMapping // GET http://----/users/
    public Iterable<UserDto> getAllUserDto() {
        return userServiceInterface.getAllUserDto();
    }

    @PostMapping // POST http://----/users/
    public UserDto addUserDto(
            @RequestBody UserDto userDto) {
        return userServiceInterface.addUserDto(userDto);
    }

    @PutMapping // PUT http://----/users/
    public UserDto updateUserDto(
            @RequestBody UserDto userDto) {
        if(userDto.getId()!=null)
            return userServiceInterface.updateUserDto(userDto);
        else
            return null; // exception
    }

    @DeleteMapping("{id}") // DELETE http://---/users/1
    public void deleteUserDto(@PathVariable Long id) {
        userServiceInterface.deleteUserDto(id);
    }
}
