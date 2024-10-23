package com.example.zomato.controller;

import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.responsedtos.CuisineResponse;
import com.example.zomato.service.CuisineService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class CuisineController {

    private final AppResponseBuilder appResponseBuilder;
    private final CuisineService cuisineService;

    @PostMapping("/cuisines/{restaurantId}")
    public ResponseEntity<ResponseStructure<CuisineResponse>> addCuisine(@RequestBody @Valid CuisineRequest cuisineRequest, @PathVariable String restaurantId) {
        CuisineResponse cuisineResponse = cuisineService.saveCuisine(cuisineRequest, restaurantId);
        return appResponseBuilder.success(HttpStatus.CREATED, "Cuisine created", cuisineResponse);
    }

    @GetMapping("/cuisines")
    public ResponseEntity<ResponseStructure<List<CuisineResponse>>> getCuisines(){
        List<CuisineResponse> cuisineResponse = cuisineService.getAllCuisines();
        return appResponseBuilder.success(HttpStatus.CREATED, "Cuisine found", cuisineResponse);
    }
}

