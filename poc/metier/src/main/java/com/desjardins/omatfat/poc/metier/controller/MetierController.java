package com.desjardins.omatfat.poc.metier.controller;

import com.desjardins.omatfat.poc.metier.entity.MetierEntity;
import com.desjardins.omatfat.poc.metier.service.MetierServiceImplementation;
import com.desjardins.omatfat.poc.metier.service.MetierServiceInterface;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("metiers")
public class MetierController {

    //@Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    private final MetierServiceInterface metierServiceInterface;

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
