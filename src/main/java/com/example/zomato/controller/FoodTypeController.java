package com.example.zomato.controller;


import com.example.zomato.repository.FoodTypeRepository;
import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import com.example.zomato.service.FoodTypeService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class FoodTypeController {

    private FoodTypeService foodTypeService;
    private final AppResponseBuilder appResponseBuilder;
    private final FoodTypeRepository foodTypeRepository;

    @PostMapping("/foodType")
    public ResponseEntity<ResponseStructure<FoodTypeResponse>> addFoodType(@RequestBody @Valid FoodTypeRequest
                                                                                   foodTypeRequest) {

        if (foodTypeRepository.existsByTitleIgnoreCase(foodTypeRequest.getTitle())) {
            throw new IllegalArgumentException("Food type with this title already exists.");
        }
        FoodTypeResponse foodTypeResponse = foodTypeService.saveFoodType(foodTypeRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "FoodType created", foodTypeResponse);
    }

    @GetMapping("/foodType")
    public ResponseEntity<ResponseStructure<List<String>>> findAllFoodType() {
        List<String> foodTypeResponse = foodTypeService.findAllFoodTypes();
        return appResponseBuilder.success(HttpStatus.FOUND, "FoodType found", foodTypeResponse);
    }
}
