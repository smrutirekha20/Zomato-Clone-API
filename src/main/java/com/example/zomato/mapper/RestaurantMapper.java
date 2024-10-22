package com.example.zomato.mapper;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapper {
    public Restaurant mapToRestaurant(RestaurantRequest restaurantRequest, Restaurant restaurant) {
        restaurant.setName(restaurantRequest.getName());
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setEmail(restaurantRequest.getEmail());
        restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
        restaurant.setDietTypes(restaurantRequest.getDietTypes());
        return restaurant;
    }

    public RestaurantResponse mapToRestaurantResponse(Restaurant restaurant) {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantResponse.setRestaurantId(restaurant.getRestaurantId());
        restaurantResponse.setName(restaurant.getName());
        restaurantResponse.setDescription(restaurant.getDescription());
        restaurantResponse.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantResponse.setEmail(restaurant.getEmail());
        restaurantResponse.setDietTypes(restaurant.getDietTypes());

        return restaurantResponse;
    }
}

