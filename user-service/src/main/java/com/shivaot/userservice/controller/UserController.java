package com.shivaot.userservice.controller;

import com.shivaot.userservice.entity.User;
import com.shivaot.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Shiva Created on 02/04/23
 */
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

     @Autowired
    private UserService userService;

     @PostMapping
     public ResponseEntity<User> createUser(@RequestBody User user) {
         User user1 = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
     }

     @GetMapping("/{userId}")
     @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
     public ResponseEntity<User> getUser(@PathVariable String userId) {
         return ResponseEntity.ok(userService.getUser(userId));
     }

     @GetMapping
     public ResponseEntity<List<User>> getUsers() {
         return ResponseEntity.ok(userService.getUsers());
     }

     private ResponseEntity<User> ratingHotelFallback(@PathVariable String userId, Exception exception) {
         log.info("Fallback of Rating or Hotel {}", exception.getMessage());
         User user = User.builder().userId(userId).ratings(null).about("dummy").email("default").name("dummy").build();
         return new ResponseEntity<>(user, HttpStatus.OK);
     }
}
