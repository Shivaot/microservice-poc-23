package com.shivaot.userservice.feign;

import com.shivaot.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Shiva Created on 03/04/23
 */
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelProxy {

    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
