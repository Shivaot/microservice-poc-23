package com.shivaot.userservice.service;


import com.shivaot.userservice.entity.User;

import java.util.List;

/**
 * Shiva Created on 02/04/23
 */
public interface UserService {

    User saveUser(User user);

    List<User> getUsers();

    User getUser(String userId);
}
