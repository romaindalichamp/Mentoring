package com.desjardins.omatfat.poc.interaction.service;

import com.desjardins.omatfat.poc.interaction.dto.InteractionDto;
import com.desjardins.omatfat.poc.interaction.repository.InteractionRepository;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 * REST Template documentation: https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
 */
@RequiredArgsConstructor
@Service
public class InteractionServiceImplementation implements InteractionServiceInterface {

    public static final String jsonUri = "metiers/";
    //@Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    private final InteractionRepository interactionRepository;
    @Value("${desjardins.omafat.poc.metier.url}")
    private String metierUrl;

    public InteractionDto getInteractionEntity(Long id) {
        return interactionRepository
                .getForObject(metierUrl + jsonUri + id, InteractionDto.class);
    }

    public List<InteractionDto> getAllInteractionEntity() {
        InteractionDto[] interactionDtos =
                interactionRepository
                        .getForObject(metierUrl + jsonUri, InteractionDto[].class);
        return Arrays.asList(interactionDtos);
    }

    public InteractionDto addInteractionEntity(InteractionDto interactionEntity) {
        return interactionRepository
                .postForObject(metierUrl + jsonUri, interactionEntity, InteractionDto.class);
    }

    public InteractionDto updateInteractionEntity(InteractionDto interactionEntity) {
        interactionRepository.put(metierUrl + jsonUri, interactionEntity);
        return getInteractionEntity(interactionEntity.getId());
    }

    public void deleteInteractionEntity(Long id) {
        interactionRepository.delete(metierUrl + jsonUri + id);
    }
}
