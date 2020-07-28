package com.company.omatfat.poc.interaction.controller;

import com.company.omatfat.poc.interaction.dto.InteractionDto;
import com.company.omatfat.poc.interaction.service.api.InteractionServiceApi;
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
@RequestMapping("interactions")
public class InteractionController {

    // @Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    // Important: "final" pour que Spring fasse l'injection de dépendance dans le constructeur
    // permet d'avoir les exceptions dès l'initialisation de la classe
    private final InteractionServiceApi interactionServiceInterface;

    @GetMapping("{id}") // ---/interactions/1
    public InteractionDto getInteractionEntity(@PathVariable Long id) {
        return interactionServiceInterface.getInteractionEntity(id);
    }

    @GetMapping // ---/interactions/
    public Iterable<InteractionDto> getAllInteractionEntity() {
        return interactionServiceInterface.getAllInteractionEntity();
    }

    @PostMapping // ---/interactions/
    public InteractionDto addInteractionEntity(
            @RequestBody InteractionDto interactionEntity) {
        return interactionServiceInterface.addInteractionEntity(interactionEntity);
    }

    @PutMapping // ---/interactions/
    public InteractionDto updateInteractionEntity(
            @RequestBody InteractionDto interactionEntity) {
        if(interactionEntity.getId()!=null)
            return interactionServiceInterface.updateInteractionEntity(interactionEntity);
        else
            return null; // exception
    }

    @DeleteMapping("{id}") // ---/interactions/1
    public void deleteInteractionEntity(@PathVariable Long id) {
        interactionServiceInterface.deleteInteractionEntity(id);
    }
}
