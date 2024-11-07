package com.example.zomato.service;

import com.example.zomato.entity.Address;
import com.example.zomato.entity.Cuisine;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapper.CuisineMapper;
import com.example.zomato.repository.CuisineRepository;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.responsedtos.CuisineResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CuisineService {

    private final RestaurantRepository restaurantRepository;
    private final CuisineMapper cuisineMapper;
    private final CuisineRepository cuisineRepository;

    public CuisineResponse saveCuisine(CuisineRequest cuisineRequest, String restaurantId) {
        Cuisine cuisine = cuisineMapper.mapToCuisine(cuisineRequest, new Cuisine());
        cuisine = cuisineRepository.save(cuisine);
        if (restaurantId != null) {
            Restaurant restaurant = restaurantRepository.findById(restaurantId)
                    .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found by given id"));
            List<Cuisine> cuisines=restaurant.getCuisines();
            cuisines.add(cuisine);
            restaurant.setCuisines(cuisines);
            System.out.println(cuisine.getTitle());
            restaurantRepository.save(restaurant);

        }
        return cuisineMapper.mapToCuisineResponse(cuisine);
    }

    public List<CuisineResponse> getAllCuisines() {
        return cuisineRepository.findAll()
                .stream().map(cuisineMapper::mapToCuisineResponse).toList();
    }
}
