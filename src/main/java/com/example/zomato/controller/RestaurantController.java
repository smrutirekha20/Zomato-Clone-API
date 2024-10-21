package com.example.zomato.controller;

import com.example.zomato.repository.RestaurantRepository;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.requestdtos.RestaurantRequest;
import com.example.zomato.service.RestaurantService;
import com.example.zomato.service.ImageService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ErrorStructure;
import com.example.zomato.utility.ResponseStructure;
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
    public ResponseEntity<ResponseStructure<RestaurantResponse>> addRestaurant(@RequestBody RestaurantRequest
                                                                                    restaurantRequest){
        RestaurantResponse restaurantResponse = restaurantService.saveRestaurant(restaurantRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "Restaurant created", restaurantResponse);
    }
    @PutMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> updateRestaurant(@RequestBody RestaurantRequest restaurantRequest,@PathVariable String restaurantId){

        RestaurantResponse restaurantResponse=restaurantService.updateRestaurant(restaurantRequest,restaurantId);
        return appResponseBuilder.success(HttpStatus.OK,"Restaurant updated", restaurantResponse);
    }

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<ResponseStructure<RestaurantResponse>> findRestaurantById(@PathVariable String restaurantId){
        RestaurantResponse restaurantResponse= restaurantService.findRestaurantById(restaurantId);
        return appResponseBuilder.success(HttpStatus.FOUND,"Restaurant found by given id",restaurantResponse);
    }

    @PutMapping("/restaurants/{restaurantId}/image")
    public ResponseEntity<ResponseStructure<String>> uploadImageToRestaurant(@PathVariable String restaurantId,@RequestParam MultipartFile file) throws IOException {

        String url =restaurantService.uploadImageToRestaurant(restaurantId,file);
        return appResponseBuilder.success(HttpStatus.OK,"image uploaded", url);
    }
}
