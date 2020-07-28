package com.company.omatfat.poc.interaction.service.api;

import com.company.omatfat.poc.interaction.dto.UserDto;
import java.util.List;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 * Contient toutes les méthodes publiques de son implémentation
 */
public interface UserServiceApi {
    UserDto getUserDto(Long id);
    List<UserDto> getAllUserDto();
    UserDto addUserDto(UserDto userDto);
    UserDto updateUserDto(UserDto userDto);
    void deleteUserDto(Long id);
}
