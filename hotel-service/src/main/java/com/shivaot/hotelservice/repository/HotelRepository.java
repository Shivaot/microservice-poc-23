package com.shivaot.hotelservice.repository;

/**
 * Shiva Created on 02/04/23
 */
import com.shivaot.hotelservice.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {
}