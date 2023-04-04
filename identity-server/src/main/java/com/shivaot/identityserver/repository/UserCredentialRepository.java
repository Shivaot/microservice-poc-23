package com.shivaot.identityserver.repository;

import com.shivaot.identityserver.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Shiva Created on 03/04/23
 */
public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByName(String username);
}
