package com.desjardins.omatfat.poc.metier.repository;

import com.desjardins.omatfat.poc.metier.entity.MetierEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Repository
public interface MetierRepository extends JpaRepository<MetierEntity, Long> {

}
