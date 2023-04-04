package com.shivaot.identityserver.service;

import com.shivaot.identityserver.config.CustomUserDetail;
import com.shivaot.identityserver.entity.UserCredential;
import com.shivaot.identityserver.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Shiva Created on 04/04/23
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> credential = userCredentialRepository.findByName(username);

        return credential.map(CustomUserDetail::new).orElseThrow(() -> new UsernameNotFoundException("User not found with username " + username));
    }
}
