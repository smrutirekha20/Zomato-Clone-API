package com.example.zomato.controller;

import com.example.zomato.entity.Restaurant;
import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.service.ImageService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class RestaurantController {
    private RestaurantService restaurantService;
    private AppResponseBuilder appResponseBuilder;
    private RestaurantRepository restaurantRepository;
    private ImageService imageService;

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

    public ResponseEntity<ErrorStructure<RestaurantResponse>> uploadImage(@PathVariable String restaurantId,@RequestParam MultipartFile file) throws IOException {
     RestaurantResponse restaurantResponse=restaurantService.findRestaurantById(restaurantId);
        String imageUrl= imageService.uploadImage(file);
        restaurantService.uploadRestaurantImage(restaurantId,imageUrl);
        return appResponseBuilder.success(HttpStatus.OK,"image uploaded", restaurantResponse);
    }
}
