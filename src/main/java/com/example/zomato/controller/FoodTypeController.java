package com.example.zomato.controller;


import com.example.zomato.requestdtos.FoodTypeRequest;
import com.example.zomato.responsedtos.FoodTypeResponse;
import com.example.zomato.responsedtos.RestaurantResponse;
import com.example.zomato.service.FoodTypeService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${zomato.base_url}")
public class FoodTypeController {

    private FoodTypeService foodTypeService;
    private final AppResponseBuilder appResponseBuilder;

    @PostMapping("/foodType")
    public ResponseEntity<ResponseStructure<FoodTypeResponse>> addFoodType(@RequestBody @Valid FoodTypeRequest
                                                                                   foodTypeRequest) {
        FoodTypeResponse foodTypeResponse = foodTypeService.saveFoodType(foodTypeRequest);
        return appResponseBuilder.success(HttpStatus.CREATED, "FoodType created", foodTypeResponse);
    }

    @GetMapping("/foodType/{typeId}")
    public ResponseEntity<ResponseStructure<FoodTypeResponse>> findFoodTypeById(@PathVariable @Valid String typeId) {
        FoodTypeResponse foodTypeResponse = foodTypeService.findFoodTypeById(typeId);
        return appResponseBuilder.success(HttpStatus.FOUND, "FoodType found by given id", foodTypeResponse);
    }
}
