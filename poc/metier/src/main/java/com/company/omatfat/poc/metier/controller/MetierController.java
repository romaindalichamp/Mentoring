package com.company.omatfat.poc.metier.controller;

import com.company.omatfat.poc.metier.entity.MetierEntity;
import com.company.omatfat.poc.metier.service.api.MetierServiceApi;
import java.util.List;
import java.util.Optional;
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
@RestController
@RequiredArgsConstructor
@RequestMapping("metiers")
public class MetierController {

    // @Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    // Important: "final" pour que Spring fasse l'injection de dépendance dans le constructeur
    // permet d'avoir les exceptions dès l'initialisation de la classe
    private final MetierServiceApi metierServiceInterface;

    @GetMapping("{id}")
    public Optional<MetierEntity> getMetierEntity(@PathVariable Long id) {
        return metierServiceInterface.getMetierEntity(id);
    }

    @GetMapping
    public List<MetierEntity> getAllMetierEntity() {
        return metierServiceInterface.getAllMetierEntity();
    }

    @PostMapping
    public MetierEntity addMetierEntity(@RequestBody MetierEntity metierEntity) {
        return metierServiceInterface.addMetierEntity(metierEntity);
    }

    @PutMapping
    public MetierEntity updateMetierEntity(@RequestBody MetierEntity metierEntity) {
        return metierServiceInterface.updateMetierEntity(metierEntity);
    }

    @DeleteMapping("{id}")
    public void UpdateMetierEntity(@PathVariable Long id) {
        metierServiceInterface.deleteMetierEntity(id);
    }
}
