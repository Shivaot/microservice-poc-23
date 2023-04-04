package com.shivaot.userservice.feign;

import com.shivaot.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Shiva Created on 03/04/23
 */
@FeignClient(name = "RATING-SERVICE")
public interface RatingProxy {

    @GetMapping("/ratings/users/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable String userId);
}
