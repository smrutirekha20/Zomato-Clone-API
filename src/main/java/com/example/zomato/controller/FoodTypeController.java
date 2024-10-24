package com.example.zomato.controller;


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

    @GetMapping("/foodType/{title}")
    public ResponseEntity<ResponseStructure<FoodTypeResponse>> findFoodTypeById(@PathVariable @Valid String title) {
        FoodTypeResponse foodTypeResponse = foodTypeService.findFoodTypeByTitle(title);
        return appResponseBuilder.success(HttpStatus.FOUND, "FoodType found by given title", foodTypeResponse);
    }
}
