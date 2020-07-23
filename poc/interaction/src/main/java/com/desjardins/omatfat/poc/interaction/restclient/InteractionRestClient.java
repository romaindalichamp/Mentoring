package com.desjardins.omatfat.poc.interaction.restclient;

import com.desjardins.omatfat.poc.interaction.dto.InteractionDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Component
public class InteractionRestClient extends RestTemplate {

    public static final String jsonUri = "metiers/";
    @Value("${desjardins.omafat.poc.metier.url}")
    private String metierUrl;

    public InteractionDto getInteractionEntity(Long id) {
        return getForObject(metierUrl + jsonUri + id, InteractionDto.class);
    }

    public List<InteractionDto> getAllInteractionEntity() {
        InteractionDto[] interactionDtos =
                getForObject(metierUrl + jsonUri, InteractionDto[].class);
        return Arrays.asList(interactionDtos);
    }

    public InteractionDto addInteractionEntity(InteractionDto interactionEntity) {
        return postForObject(metierUrl + jsonUri, interactionEntity, InteractionDto.class);
    }

    public InteractionDto updateInteractionEntity(InteractionDto interactionEntity) {
        put(metierUrl + jsonUri, interactionEntity);
        return getInteractionEntity(interactionEntity.getId());
    }

    public void deleteInteractionEntity(Long id) {
        delete(metierUrl + jsonUri + id);
    }
}
