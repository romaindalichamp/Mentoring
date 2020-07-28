package com.company.omatfat.poc.interaction.service.impl;

import com.company.omatfat.poc.interaction.dto.UserDto;
import com.company.omatfat.poc.interaction.restclient.UserRestClient;
import com.company.omatfat.poc.interaction.service.api.UserServiceApi;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 * REST Template documentation: https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServiceApi {

    private final UserRestClient userRestClient;

    public UserDto getUserDto(Long id) {
        // Business rules
        return userRestClient.getUserDto(id);
    }

    public List<UserDto> getAllUserDto() {
        // Business rules
        return userRestClient.getAllUserDto();
    }

    public UserDto addUserDto(UserDto interactionEntity) {
        // Business rules
        return userRestClient.addUserDto(interactionEntity);
    }

    public UserDto updateUserDto(UserDto interactionEntity) {
        // Business rules
        return userRestClient.updateUserDto(interactionEntity);
    }

    public void deleteUserDto(Long id) {
        // Business rules
        userRestClient.deleteUserDto(id);
    }
}
