package com.shivaot.hotelservice.service;

import com.shivaot.hotelservice.entity.Hotel;

import java.util.List;

/**
 * Shiva Created on 02/04/23
 */
public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);

}