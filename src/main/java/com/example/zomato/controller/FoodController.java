package com.example.zomato.controller;

import com.example.zomato.requestdtos.FoodRequest;
import com.example.zomato.responsedtos.FoodResponse;
import com.example.zomato.service.FoodService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class FoodController {

    private final FoodService foodService;
    private final AppResponseBuilder appResponseBuilder;

    @PreAuthorize("hasAuthority('RESTAURANT_WRITE')")
    @PostMapping("/food/{restaurantId}/{menuCategoryId}/{cuisineId}/{typeId}")
    public ResponseEntity<ResponseStructure<FoodResponse>> addFood(@RequestBody @Valid FoodRequest foodRequest,@PathVariable String restaurantId,@PathVariable String menuCategoryId,@PathVariable String cuisineId,@PathVariable String typeId) {
        FoodResponse foodResponse= foodService.saveFood(foodRequest,restaurantId,menuCategoryId,cuisineId,typeId);
        return appResponseBuilder.success(HttpStatus.CREATED, "Food created", foodResponse);
    }
}
