package com.desjardins.omatfat.poc.interaction.service;

import com.desjardins.omatfat.poc.interaction.dto.InteractionDto;
import java.util.List;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 * Contient toutes les méthodes publiques de son implémentation
 */
public interface InteractionServiceInterface {
    InteractionDto getInteractionEntity(Long id);
    List<InteractionDto> getAllInteractionEntity();
    InteractionDto addInteractionEntity(InteractionDto interactionEntity);
    InteractionDto updateInteractionEntity(InteractionDto interactionEntity);
    void deleteInteractionEntity(Long id);
}
