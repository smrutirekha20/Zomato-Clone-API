package com.example.zomato.controller;

import com.example.zomato.entity.MenuCategory;
import com.example.zomato.requestdtos.AddressRequest;
import com.example.zomato.requestdtos.CuisineRequest;
import com.example.zomato.requestdtos.MenuCategoryRequest;
import com.example.zomato.responsedtos.AddressResponse;
import com.example.zomato.responsedtos.CuisineResponse;
import com.example.zomato.responsedtos.MenuCategoryResponse;
import com.example.zomato.service.MenuCategoryService;
import com.example.zomato.utility.AppResponseBuilder;
import com.example.zomato.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${zomato.base_url}")
@AllArgsConstructor
public class MenuCategoryController {

    private final MenuCategoryService menuCategoryService;
    private final AppResponseBuilder appResponseBuilder;

    @PostMapping("/menu_categories/{restaurantId}")
    public ResponseEntity<ResponseStructure<MenuCategoryResponse>> addCuisine(@RequestBody @Valid MenuCategoryRequest menuCategoryRequest, @PathVariable String restaurantId) {
        MenuCategoryResponse menuCategoryResponse = menuCategoryService.saveMenuCategory(menuCategoryRequest, restaurantId);
        return appResponseBuilder.success(HttpStatus.CREATED, "MenuCategory created", menuCategoryResponse);
    }

    @PutMapping("/menu_categories/{menuCategoryId}")
    public ResponseEntity<ResponseStructure<MenuCategoryResponse>> updateMenuCategory(@RequestBody @Valid MenuCategoryRequest menuCategoryRequest, @PathVariable String menuCategoryId) {
        MenuCategoryResponse menuCategoryResponse = menuCategoryService.updateMenuCategory(menuCategoryRequest, menuCategoryId);
        return appResponseBuilder.success(HttpStatus.CREATED, "MenuCategory updated", menuCategoryResponse);
    }
}
