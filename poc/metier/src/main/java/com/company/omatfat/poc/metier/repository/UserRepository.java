package com.company.omatfat.poc.metier.repository;

import com.company.omatfat.poc.metier.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Romain DALICHAMP - romain.dalichamp@alithya.com
 * <p>
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
