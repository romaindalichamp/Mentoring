package com.desjardins.omatfat.poc.interaction.service.impl;

import com.desjardins.omatfat.poc.interaction.dto.InteractionDto;
import com.desjardins.omatfat.poc.interaction.restclient.InteractionRestClient;
import com.desjardins.omatfat.poc.interaction.service.api.InteractionServiceApi;
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
public class InteractionServiceImpl implements InteractionServiceApi {

    private final InteractionRestClient interactionRestClient;

    public InteractionDto getInteractionEntity(Long id) {
        // Business rules
        return interactionRestClient.getInteractionEntity(id);
    }

    public List<InteractionDto> getAllInteractionEntity() {
        // Business rules
        return interactionRestClient.getAllInteractionEntity();
    }

    public InteractionDto addInteractionEntity(InteractionDto interactionEntity) {
        // Business rules
        return interactionRestClient.addInteractionEntity(interactionEntity);
    }

    public InteractionDto updateInteractionEntity(InteractionDto interactionEntity) {
        // Business rules
        return interactionRestClient.updateInteractionEntity(interactionEntity);
    }

    public void deleteInteractionEntity(Long id) {
        // Business rules
        interactionRestClient.deleteInteractionEntity(id);
    }
}
