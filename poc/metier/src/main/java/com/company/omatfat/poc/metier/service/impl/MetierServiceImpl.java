package com.company.omatfat.poc.metier.service.impl;

import com.company.omatfat.poc.metier.entity.MetierEntity;
import com.company.omatfat.poc.metier.repository.MetierRepository;
import com.company.omatfat.poc.metier.service.api.MetierServiceApi;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class MetierServiceImpl implements MetierServiceApi {

    //@Autowired est remplacé par ==> @RequiredArgsConstructor de Lombok
    private final MetierRepository metierRepository;

    public Optional<MetierEntity> getMetierEntity(Long id) {
        log.info("get");
        // Business rules
        return metierRepository.findById(id);
    }

    public List<MetierEntity> getAllMetierEntity() {
        log.info("get alls");
        // Business rules
        return metierRepository.findAll();
    }

    public MetierEntity addMetierEntity(MetierEntity metierEntity) {
        log.info("add");
        // Business rules
        return metierRepository.save(metierEntity);
    }

    public MetierEntity updateMetierEntity(MetierEntity metierEntity) {
        log.info("update");
        // Business rules
        return metierRepository.save(metierEntity);
    }

    public void deleteMetierEntity(Long id) {
        log.info("deleteById");
        // Business rules
        metierRepository.deleteById(id);
    }

}
