package com.desjardins.omatfat.poc.metier.service;

import com.desjardins.omatfat.poc.metier.entity.MetierEntity;
import java.util.List;
import java.util.Optional;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
public interface MetierServiceInterface {
    Optional<MetierEntity> getMetierEntity(Long id);
    List<MetierEntity> getAllMetierEntity();
    MetierEntity addMetierEntity(MetierEntity metierEntity);
    MetierEntity updateMetierEntity(MetierEntity metierEntity);
    void deleteMetierEntity(Long id);
}
