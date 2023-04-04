package com.shivaot.identityserver.controller;

import com.shivaot.identityserver.dto.AuthRequest;
import com.shivaot.identityserver.entity.UserCredential;
import com.shivaot.identityserver.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Shiva Created on 03/04/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public String createUser(@RequestBody UserCredential userCredential) {
        return authService.saveUser(userCredential);
    }

    @GetMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) return authService.generateToken(authRequest.getUsername());
        throw new RuntimeException("Invalid Access");
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token is valid";
    }
}
