package com.company.omatfat.poc.interaction.restclient;

import com.company.omatfat.poc.interaction.dto.UserDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Component
public class UserRestClient extends RestTemplate {

    public static final String jsonUri = "users/";

    @Value("${company.omafat.poc.metier.url}")
    private String metierUrl;

    public UserDto getUserDto(Long id) {
        return getForObject(metierUrl + jsonUri + id, UserDto.class);
    }

    public List<UserDto> getAllUserDto() {
        UserDto[] userDtos =
                getForObject(metierUrl + jsonUri, UserDto[].class);
        return Arrays.asList(userDtos);
    }

    public UserDto addUserDto(UserDto userDto) {
        return postForObject(metierUrl + jsonUri, userDto, UserDto.class);
    }

    public UserDto updateUserDto(UserDto userDto) {
        put(metierUrl + jsonUri, userDto);
        return getUserDto(userDto.getId());
    }

    public void deleteUserDto(Long id) {
        delete(metierUrl + jsonUri + id);
    }
}
