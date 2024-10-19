package com.example.zomato.mapper;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RestaurantMapper {

    private AddressMapper addressMapper;
    public Restaurant mapToRestaurant(RestaurantRequest restaurantRequest, Restaurant restaurant){
        restaurant.setName(restaurantRequest.getName());
        restaurant.setDescription(restaurantRequest.getDescription());
        restaurant.setEmail(restaurantRequest.getEmail());
        restaurant.setPhoneNumber(restaurantRequest.getPhoneNumber());
        restaurant.setDietTypes(restaurantRequest.getDietTypes());
        return restaurant;
    }
    public RestaurantResponse mapToRestaurantResponse(Restaurant restaurant){
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        restaurantResponse.setRestaurantId(restaurant.getRestaurantId());
        restaurantResponse.setName(restaurant.getName());
        restaurantResponse.setDescription(restaurant.getDescription());
        restaurantResponse.setPhoneNumber(restaurant.getPhoneNumber());
        restaurantResponse.setEmail(restaurant.getEmail());
        restaurantResponse.setDietTypes(restaurant.getDietTypes());
        restaurantResponse.setAddressResponse(addressMapper.mapToAddressResponse(restaurant.getAddress()));
        return restaurantResponse;
    }
}

