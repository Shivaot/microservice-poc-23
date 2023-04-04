package com.shivaot.userservice.repository;

import com.shivaot.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Shiva Created on 02/04/23
 */
public interface UserRepository extends JpaRepository<User, String> {
}
