package com.shivaot.userservice.service.impl;

import com.shivaot.userservice.entity.Hotel;
import com.shivaot.userservice.entity.Rating;
import com.shivaot.userservice.entity.User;
import com.shivaot.userservice.exceptions.ResourceNotFoundException;
import com.shivaot.userservice.feign.HotelProxy;
import com.shivaot.userservice.feign.RatingProxy;
import com.shivaot.userservice.repository.UserRepository;
import com.shivaot.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Shiva Created on 02/04/23
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RatingProxy ratingProxy;
    @Autowired
    private HotelProxy hotelProxy;

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(user -> getUser(user.getUserId())).toList();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Not found with userid " + userId));
        List<Rating> ratingsByUserId = ratingProxy.getRatingsByUserId(userId);

        List<Rating> ratings = ratingsByUserId.stream().map(rating -> {
            Hotel hotel = hotelProxy.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).toList();

        user.setRatings(ratings);
        return user;
    }
}
