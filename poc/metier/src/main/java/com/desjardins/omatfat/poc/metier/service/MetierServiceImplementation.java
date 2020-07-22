package com.desjardins.omatfat.poc.metier.service;

import com.desjardins.omatfat.poc.metier.entity.MetierEntity;
import com.desjardins.omatfat.poc.metier.repository.MetierRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class MetierServiceImplementation implements MetierServiceInterface {

    //@Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    private final MetierRepository metierRepository;

    public Optional<MetierEntity> getMetierEntity(Long id) {
        log.info("get");
        return metierRepository.findById(id);
    }

    public List<MetierEntity> getAllMetierEntity() {
        log.info("get alls");
        return metierRepository.findAll();
    }

    public MetierEntity addMetierEntity(MetierEntity metierEntity) {
        log.info("add");
        return metierRepository.save(metierEntity);
    }

    public MetierEntity updateMetierEntity(MetierEntity metierEntity) {
        log.info("update");
        return metierRepository.save(metierEntity);
    }

    public void deleteMetierEntity(Long id) {
        log.info("deleteById");
        metierRepository.deleteById(id);
    }

}
