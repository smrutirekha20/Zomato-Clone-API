package com.example.zomato.controller;

import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;
    private AppResponseBuilder appResponseBuilder;

    @PostMapping("/restaurants")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest
                                                                                    restaurantRequest) {
        RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Restaurant created", restaurantResponse);
    }
}

