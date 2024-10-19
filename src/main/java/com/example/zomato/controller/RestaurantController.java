package com.example.zomato.controller;

import com.example.zomato.entity.Address;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;
    private AppResponseBuilder appResponseBuilder;

    @PostMapping("/restaurants")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest
                                                                                    restaurantRequest){
        RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Restaurant created", restaurantResponse);
    }
    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> updateRestaurant(@RequestBody RestaurantRequest restaurantRequest,@PathVariable String restaurantId){

        RestaurantResponse restaurantResponse=restaurantService.updateRestaurant(restaurantRequest,restaurantId);
        return appResponseBuilder.success(HttpStatus.OK,"Restaurant updated", restaurantResponse);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ErrorStructure<RestaurantResponse>> findRestaurantById(@PathVariable String restaurantId){
        RestaurantResponse restaurantResponse= restaurantService.findRestaurantById(restaurantId);
        return appResponseBuilder.success(HttpStatus.FOUND,"Restaurant found by given id",restaurantResponse);
    }
}

