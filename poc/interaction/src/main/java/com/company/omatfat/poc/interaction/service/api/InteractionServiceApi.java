package com.company.omatfat.poc.interaction.service.api;

import com.company.omatfat.poc.interaction.dto.InteractionDto;
import java.util.List;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 * Contient toutes les méthodes publiques de son implémentation
 */
public interface InteractionServiceApi {
    InteractionDto getInteractionEntity(Long id);
    List<InteractionDto> getAllInteractionEntity();
    InteractionDto addInteractionEntity(InteractionDto interactionEntity);
    InteractionDto updateInteractionEntity(InteractionDto interactionEntity);
    void deleteInteractionEntity(Long id);
}
