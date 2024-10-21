package com.example.zomato.service;

import com.example.zomato.entity.Address;
import com.example.zomato.entity.Image;
import com.example.zomato.entity.Restaurant;
import com.example.zomato.exception.RestaurantNotFoundByIdException;
import com.example.zomato.mapper.AddressMapper;
import com.example.zomato.mapper.RestaurantMapper;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    private RestaurantMapper restaurantMapper;
    private final ImageService imageService;

    public RestaurantResponse saveRestaurant(RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.save(restaurantMapper.mapToRestaurant(restaurantRequest, new Restaurant()));//user is created with unique identifier
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

    public String uploadImageToRestaurant(String restaurantId, MultipartFile file) {

        return restaurantRepository.findById(restaurantId)
                .map(restaurant -> {
                    try {
                        String url = imageService.uploadImage(file);
                        restaurant.setImageUrl(url);
                        restaurantRepository.save(restaurant);
                        return url;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                })
                .orElseThrow(() -> new RestaurantNotFoundByIdException("Restaurant not found bt id"));

    }
}

