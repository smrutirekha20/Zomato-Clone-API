package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.entity.RestaurantOwner;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.security.AuthUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    private RestaurantMapper restaurantMapper;
    private AuthUtil authUtil;
    public RestaurantResponse saveRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant=restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant());//user is created with unique identifier
        restaurant.setRestaurantOwner((RestaurantOwner) authUtil.getCurrentUser());
        restaurantRepository.save(restaurant);
        return restaurantMapper.mapToRestaurantResponse(restaurant);

    }

    public RestaurantResponse updateRestaurant(RestaurantRequest restaurantRequest, String restaurantId) {

        return restaurantRepository.findById(restaurantId)
                .map(exRestaurant -> {
                    exRestaurant = restaurantMapper.mapToRestaurant(restaurantRequest, exRestaurant);
                    exRestaurant = restaurantRepository.save(exRestaurant);
                    return restaurantMapper.mapToRestaurantResponse(exRestaurant);

                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Failed To Update Restaurant"));
    }

    public RestaurantResponse findRestaurantById(String restaurantId) {

        return restaurantRepository.findById(restaurantId)
                .map(restaurantMapper::mapToRestaurantResponse)
                .orElseThrow(() -> new RestaurantNotFoundByIdException("user not found by id"));
    }
}
