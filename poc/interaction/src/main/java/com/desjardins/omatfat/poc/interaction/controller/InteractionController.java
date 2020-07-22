package com.desjardins.omatfat.poc.interaction.controller;

import com.desjardins.omatfat.poc.interaction.dto.InteractionDto;
import com.desjardins.omatfat.poc.interaction.service.InteractionServiceImplementation;
import com.desjardins.omatfat.poc.interaction.service.InteractionServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("interactions")
public class InteractionController {

    //@Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    private final InteractionServiceInterface interactionServiceInterface;

    @GetMapping("{id}")
    public InteractionDto getInteractionEntity(@PathVariable Long id) {
        return interactionServiceInterface.getInteractionEntity(id);
    }

    @GetMapping
    public Iterable<InteractionDto> getAllInteractionEntity() {
        return interactionServiceInterface.getAllInteractionEntity();
    }

    @PostMapping
    public InteractionDto addInteractionEntity(
            @RequestBody InteractionDto interactionEntity) {
        return interactionServiceInterface.addInteractionEntity(interactionEntity);
    }

    @PutMapping
    public InteractionDto updateInteractionEntity(
            @RequestBody InteractionDto interactionEntity) {
        return interactionServiceInterface.updateInteractionEntity(interactionEntity);
    }

    @DeleteMapping("{id}")
    public void UpdateInteractionEntity(@PathVariable Long id) {
        interactionServiceInterface.deleteInteractionEntity(id);
    }
}
