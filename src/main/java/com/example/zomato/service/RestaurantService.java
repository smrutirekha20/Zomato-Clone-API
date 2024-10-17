package com.example.zomato.service;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    private RestaurantMapper restaurantMapper;

    public RestaurantResponse saveRestaurant(RestaurantRequest restaurantRequest) {



            Restaurant restaurant=restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant())); //user is created with unique identifier
            return restaurantMapper.mapToRestaurantResponse(restaurant);

        }
    }
